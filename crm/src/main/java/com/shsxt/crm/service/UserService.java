package com.shsxt.crm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assume;
import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.exceptions.ParamsException;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.utils.Md5Util;
import com.shsxt.crm.utils.UserIDBase64;
import com.shsxt.crm.vo.Role;
import com.shsxt.crm.vo.User;

@Service
public class UserService extends BaseService<User>{
	@Resource
	private UserDao userDao;
	
	@Resource
	private RoleDao roleDao;
	
	
	public UserModel loginCheck(String userName,String userPwd,Integer roleId){
		/**
		 * 1.参数合法性校验  非空校验
		 * 2.执行查询  根据用户名 角色id 查询用户记录
		 *    用户存在性校验
		 *    用户是否有效校验
		 *    密码校验
		 *    获取用户必要信息 返回
		 *    
		 */
		checkParams(userName,userPwd,roleId);
		User user= userDao.queryUserByUserNameAndRoleId(userName, roleId);
		AssertUtil.isTrue(null==user, "该用户不存在!");
		// 1 有效  0 无效
		AssertUtil.isTrue(user.getIsValid()==0, "该用户已删除!");
		//  密码匹配
		AssertUtil.isTrue(!user.getUserPwd().equals(Md5Util.encode(userPwd)), "密码不准确!");
		
		UserModel userModel= buildUserBaseInfo(user);
		return  userModel;
	}

	private UserModel buildUserBaseInfo(User user) {
		UserModel userModel=new UserModel();
		userModel.setUserName(user.getUserName());
		userModel.setRoleName(user.getRoleName());
		userModel.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));// base64 加密
		return userModel;
	}


	private void checkParams(String userName, String userPwd, Integer roleId) {
		AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名不能为空!");
		AssertUtil.isTrue(StringUtils.isBlank(userPwd), "密码不能为空!");
		AssertUtil.isTrue(null==roleId||roleId==0, "请选择角色!");
	}

	
	/**
	 * 更新密码
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 */
	public void updateUserPassword(Integer userId,String oldPassword,String newPassword,String confirmPassword){
		/**
		 * 参数合法性校验
		 *   参数非空
		 * 查询用户存在性
		 *   执行密码更新 
		 */
		checkParams02(oldPassword,newPassword,confirmPassword,userId);
		User user=queryById(userId);
		AssertUtil.isTrue(null==user, "该用户记录不存在!");
		// 密码是否正确确认
		AssertUtil.isTrue(!user.getUserPwd().equals(Md5Util.encode(oldPassword)), "原始密码不正确!");
		user.setUserPwd(Md5Util.encode(newPassword));
		AssertUtil.isTrue(update(user)<1, "用户密码更新失败!");
		
		
	}

	private void checkParams02(String oldPassword, String newPassword,
			String confirmPassword, Integer userId) {
		AssertUtil.isTrue(StringUtils.isBlank(oldPassword), "原始密码不能为空!");
		AssertUtil.isTrue(StringUtils.isBlank(newPassword), "新密码不能为空!");
		AssertUtil.isTrue(StringUtils.isBlank(confirmPassword), "确认密码不能为空!");
		AssertUtil.isTrue(!newPassword.equals(confirmPassword), "两次密码输入不一致!");
		AssertUtil.isTrue(null==userId||0==userId, "用户不存在!");
	}

	public void test() {
		throw new ParamsException("异常测试...");
		
	}

	public List<User> queryCustomerManager() {
		return userDao.queryCustomerManager();
	}

	
	// 用户名不能重复（ajax 校验）
	public void saveOrUpdateUser(User user){
		user.setUpdateDate(new Date());
		
		if(null!=user.getRoleId()){
			Role role=roleDao.queryById(user.getRoleId());
			if(null!=role){
				user.setRoleName(role.getRoleName());
			}
		}
		
		// 密码123456
		if(null==user.getId()){
			user.setCreateDate(new Date());
			user.setIsValid(1);
			user.setUserPwd(Md5Util.encode("123456"));
			AssertUtil.isTrue(insert(user)<1, CrmConstant.OPTION_FAILED_MSG);
		}else{
			AssertUtil.isTrue(null==queryById(user.getId()), "待更新记录不存在!");
			AssertUtil.isTrue(update(user)<1, CrmConstant.OPTION_FAILED_MSG);
		}
	}
	
	
	
	public void queryUserByUserName(String userName){
		AssertUtil.isTrue(StringUtils.isBlank(userName), "用户名不能为空!");
		AssertUtil.isTrue(null!=userDao.queryUserByUserName(userName),"该用户已存在!");
	}
	
	
	public void deleteUserBatch(Integer[] ids){
		AssertUtil.isTrue(deleteBatch(ids)<1, CrmConstant.OPTION_FAILED_MSG);
	}

}
