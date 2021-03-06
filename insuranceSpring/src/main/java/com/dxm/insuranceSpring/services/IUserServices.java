package com.dxm.insuranceSpring.services;

import java.util.HashMap;

/**
 * 员工services接口
 */

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.dxm.insuranceSpring.pojo.Role;
import com.dxm.insuranceSpring.pojo.User;
import com.dxm.insuranceSpring.utils.APIRequest;

public interface IUserServices {
	
	public Set<String> loadRolesData(Integer userid);
	
	//带条件查询所有在职或离职员工
	public HashMap<String,Object> queryUsers(User user,Integer indexPage); 
	
	//添加员工
	public Integer insertUser(HttpServletRequest request, MultipartFile file,User user,Integer roleid);
	//Admin修改员工信息
	public Integer updateByAdmin(User user);
	//User修改个人信息
	public Integer updateByUser(HttpServletRequest request, MultipartFile mpfile,User user);
	//员工离职
	public Integer updateLeaveState(Integer leaveStatus,Integer uid);
	
	//根据id查询员工
	public HashMap<String,Object> queryUserById(Integer uid);
	
	//根据角色编号查找用户信息
	public APIRequest<User> queryUserByRoleId();

	
	//给员工添加一至多个角色
	public APIRequest addRoleToUser(Integer userid,Integer... roleid); 
	//给员工移除一至多个角色
	public APIRequest removeRoleToUser(Integer userid,Integer... roleid);
	
	//根据昵称和密码查询员工
	public APIRequest<User> selectUserByAccount(String account,String password);
}
