

package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import sun.launcher.resources.launcher;

import com.shsxt.base.BaseController;
import com.shsxt.base.exceptions.ParamsException;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.query.UserQuery;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.User;
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Resource
	private UserService userService;
	
	
	@RequestMapping("userLogin")
	@ResponseBody
	public MessageModel userLogin(User user){
		MessageModel messageModel=new MessageModel();
		try {
			UserModel userModel= userService.loginCheck(user.getUserName(), user.getUserPwd(), user.getRoleId());
			messageModel.setResult(userModel);
		} catch (ParamsException e) {
			e.printStackTrace();
			messageModel.setResultCode(CrmConstant.OPTION_FAILED_CODE);
			messageModel.setMsg(e.getMsg());
		}
		System.err.println("aaaaaaaaaaaaaaa");
		return messageModel;
	}
	
	@RequestMapping("updateUserPassword")
	@ResponseBody
	public MessageModel updateUserPassword(HttpServletRequest request,String oldPassword,String newPassword,String confirmPassword){
		MessageModel messageModel=new MessageModel();
		/*try {*/
			Integer userId=LoginUserUtil.releaseUserIdFromCookie(request);
			userService.updateUserPassword(userId, oldPassword, newPassword, confirmPassword);
		/*} catch (ParamsException e) {
			e.printStackTrace();
			messageModel.setResultCode(CrmConstant.OPTION_FAILED_CODE);
			messageModel.setMsg(e.getMsg());
		}*/
		return messageModel;
	}
	
	@RequestMapping("queryCustomerManager")
	@ResponseBody
	public List<User> queryCustomerManager(){
		return userService.queryCustomerManager();
	}
 	
	
	
	
	@RequestMapping("index")
	public String index(){
		return "user";
	}
	
	@RequestMapping("queryUserInfoByParams")
	@ResponseBody
	public Map<String, Object> queryUserInfoByParams(UserQuery userQuery,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows){
		userQuery.setPageNum(page);
		userQuery.setPageSize(rows);
		return userService.queryForPageMap(userQuery);
	}

	
	@RequestMapping("saveOrUpdateUser")
	@ResponseBody
	public MessageModel saveOrUpdateUser(User user){
		MessageModel messageModel=new MessageModel();
		userService.saveOrUpdateUser(user);
		return messageModel;
 	}
	
	@RequestMapping("checkUserUniqueByUserName")
	@ResponseBody
	public MessageModel checkUserUniqueByUserName(String userName){
		MessageModel messageModel=new MessageModel();
		userService.queryUserByUserName(userName);
		return messageModel;
	}
	
	@RequestMapping("deleteUserBatch")
	@ResponseBody
	public MessageModel deleteUserBatch(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		userService.deleteUserBatch(ids);
		return messageModel;
	}
	
}
