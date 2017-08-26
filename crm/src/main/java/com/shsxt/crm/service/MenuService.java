package com.shsxt.crm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.MenuDao;
import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.vo.Menu;

@Service
public class MenuService extends BaseService<Menu> {

	@Resource
	private MenuDao menuDao;

	@Resource
	private RoleDao roleDao;

	public void saveOrUpdateMenu(Menu menu){
		menu.setUpdateDate(new Date());
		if(null==menu.getId()){
			menu.setCreateDate(new Date());
			menu.setIsValid(1);
			AssertUtil.isTrue(insert(menu)<1, CrmConstant.OPTION_FAILED_MSG);
		}else{
			AssertUtil.isTrue(null==queryById(menu.getId()), "待更新记录不存在!");
			AssertUtil.isTrue(update(menu)<1, CrmConstant.OPTION_FAILED_MSG);
		}
	}


	// pid=10000   pid!=10000
	public void queryMenuByMenuNameAndPid(String menuName,Integer pid){
		AssertUtil.isTrue(StringUtils.isBlank(menuName), "菜单名称不能为空!");
		AssertUtil.isTrue(null==pid||0==pid, "未指定父级菜单id！");
		AssertUtil.isTrue(null!=menuDao.queryMenuByMenuNameAndPid(pid, menuName), "该菜单已存在!");
	}




	public void deleteMenuBatch(Integer mid){
		// mid  父级菜单id  子级菜单id
		/**
		 * 根据mid 查询待删除记录 id
		 *   查询子记录  List<T> children
		 *   递归查询孩子节点  integer[] ids 
		 *      mid,list<Integer>
		 */


		List<Integer> result=new ArrayList<Integer>();// 待删除id
		result.add(mid);
		result=getSubMenuIds(mid,result);// 存储所有待删除id

		Integer[] ids=new Integer[result.size()];
		for(int i=0;i<result.size();i++){
			ids[i]=result.get(i);
		}
		AssertUtil.isTrue(deleteBatch(ids)<1, CrmConstant.OPTION_FAILED_MSG);
	}


	private List<Integer> getSubMenuIds(Integer mid, List<Integer> result) {
		Menu menu= queryById(mid);
		if(null!=menu){
			List<Menu> menus=menuDao.querySubMenusByPid(menu.getId());
			if(null!=menus&&menus.size()>0){
				for(Menu temp:menus){
					result.add(temp.getId());
					result=getSubMenuIds(temp.getId(), result);
				}
			}
		}
		return result;
	}


	public List<TreeDto> queryAllMenus(){
		return menuDao.queryAllMenus();
	}

	public List<TreeDto> queryAllMenus02(Integer rid){
		// 查询当前角色 拥有菜单记录 List<integer> menuIds
		List<Integer> menuIds=roleDao.queryRoleHasMenuIds(rid);
		List<TreeDto> treeDtos=menuDao.queryAllMenus();

		if(null!=menuIds&&menuIds.size()>0){
			for(TreeDto treeDto:treeDtos){
				if(menuIds.contains(treeDto.getId())){
					treeDto.setChecked(true);
				}
			}
		}

		return treeDtos;
	}


	public List<TreeDto> queryRoleHasMenus(Integer rid){

		/**
		 * 1.查询角色拥有的根级菜单
		 * 2.查询角色拥有菜单id 选项
		 */
		List<TreeDto> roots=menuDao.queryRootMenusByRid(rid);
		
		// 查询角色拥有菜单
		List<Integer> menuIds=roleDao.queryRoleHasMenuIds(rid);
		List<TreeDto> result=new ArrayList<TreeDto>();//返回的结果list
		if(null!=roots&&roots.size()>0){
			for(TreeDto treeDto:roots){
				treeDto=getSubTreeDto(treeDto.getId(),menuIds);
				result.add(treeDto);
			}
		}



		return 	result;

	}


	/**
	 * 递归遍历 树 直到没有孩子节点   孩子节点找到  放入孩子属性中
	 * @param id
	 * @return
	 */
	private TreeDto getSubTreeDto(Integer id,List<Integer> menuIds) {
		TreeDto treeDto=menuDao.quertTreeDtoById(id);//获取当前菜单
		if(null!=treeDto){
			// 查询孩子节点
			List<TreeDto> treeDtos=menuDao.querySubTreesByPid(treeDto.getId());
			if(null!=treeDtos&&treeDtos.size()>0){
				for(TreeDto tempDto:treeDtos){
					TreeDto  treeDto02=getSubTreeDto(tempDto.getId(),menuIds);
					if(null!=menuIds&&menuIds.size()>0){
						if(menuIds.contains(treeDto02.getId())){
							treeDto.getChildren().add(treeDto02);
						}
					}	
				}
			}
		}
		return treeDto;
	}
}
