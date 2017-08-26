package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.vo.Menu;

public interface MenuDao extends BaseDao<Menu> {
	
	Menu queryMenuByMenuNameAndPid(@Param("pid")Integer pid,@Param("menuName")String menuName);
	
	
	List<Menu> querySubMenusByPid(@Param("pid") Integer pid);
	
	
	List<TreeDto> queryAllMenus();
	
	
	/**
	 * 查询根级菜单 根据角色id
	 * @param rid
	 * @return
	 */
	List<TreeDto> queryRootMenusByRid(@Param("rid") Integer rid);
	
	
	TreeDto quertTreeDtoById(@Param("id") Integer id);
    
	
	List<TreeDto> querySubTreesByPid(@Param("pid") Integer pid);
}