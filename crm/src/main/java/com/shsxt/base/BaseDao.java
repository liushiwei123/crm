package com.shsxt.base;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

/**
 * baseDao  基本crud 方法声明
 * @author lp
 *
 */
@SuppressWarnings("all")
public interface BaseDao<T> {
	
	/**
	 * 添加单条记录
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	public int insert(T entity) throws DataAccessException;
	
	/**
	 * 批量添加记录
	 * @param entites
	 * @return
	 * @throws DataAccessException
	 */
	public int insertBatch(List<T> entites) throws DataAccessException;
	
	/**
	 * 查询记录详情
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public T queryById(Integer id) throws DataAccessException;
	
	/**
	 * 分页多条件查询记录
	 * @param baseQuery
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> queryForPage(BaseQuery baseQuery) throws DataAccessException;
	
	/**
	 * 更新单条记录
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	public int update(T entity) throws DataAccessException;
	
	/**
	 * 批量更新记录
	 * @param map
	 * @return
	 * @throws DataAccessException
	 */
	public int updateBatch(Map map) throws DataAccessException;
	
	/**
	 * 删除单条记录
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public int delete(Integer id) throws DataAccessException;
	
	/**
	 * 批量删除记录
	 * @param ids
	 * @return
	 * @throws DataAccessException
	 */
	public int deleteBatch(Integer[] ids) throws DataAccessException;
	
	
	

}
