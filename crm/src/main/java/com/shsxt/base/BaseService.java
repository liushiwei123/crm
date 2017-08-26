package com.shsxt.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.base.util.AssertUtil;
@SuppressWarnings("all")
public abstract  class BaseService<T> {
	
	@Autowired
	private BaseDao<T> baseDao;
 	
	
	/**
	 * 添加单条记录
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	public int insert(T entity){
		return baseDao.insert(entity);
	} 
	
	/**
	 * 批量添加记录
	 * @param entites
	 * @return
	 * @throws DataAccessException
	 */
	public int insertBatch(List<T> entites){
		return  baseDao.insertBatch(entites);
	} 
	
	/**
	 * 查询记录详情
	 * @param id
	 * @return
	 * @throws DataAccessException id==
	 */  
	public T queryById(Integer id){
		AssertUtil.isTrue(null==id||id==0, "记录id 不能为空!");
		return  baseDao.queryById(id);
	} 
	
	/**
	 * 分页多条件查询记录
	 * @param baseQuery
	 * @return
	 * @throws DataAccessException
	 */
	public PageInfo<T> queryForPage(BaseQuery baseQuery) {
		PageHelper.startPage(baseQuery.getPageNum(), baseQuery.getPageSize());
		List<T> list=baseDao.queryForPage(baseQuery);
		return new PageInfo<T>(list);
	}
	
	/**
	 * 更新单条记录
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	public int update(T entity){
		return baseDao.update(entity);
	} 
	
	/**
	 * 批量更新记录
	 * @param map
	 * @return
	 * @throws DataAccessException
	 */
	public int updateBatch(Map map){
		return baseDao.updateBatch(map);
	} 
	
	/**
	 * 删除单条记录
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public int delete(Integer id) {
		AssertUtil.isTrue(null==id||0==id||(null==queryById(id)), "id 不能为空或待删除记录不存在!");
		return baseDao.delete(id);
	}
	
	/**
	 * 批量删除记录
	 * @param ids
	 * @return
	 * @throws DataAccessException
	 */
	public int deleteBatch(Integer[] ids) {
		AssertUtil.isTrue(null==ids||0==ids.length, "选择待删除记录执行删除操作");
		return baseDao.deleteBatch(ids);
	}
	
	
	/**
	 * 返回map 分页数据
	 *
	 */
	public Map<String,Object> queryForPageMap(BaseQuery baseQuery){
		PageInfo<T> pageInfo=queryForPage(baseQuery);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", pageInfo.getList());
		return map;
	}
	

	
}
