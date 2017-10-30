package com.sgl.action;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sgl.model.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 新增页面
	 * @return
	 */
	public String add(){
		return "success";
	}
	
	/**
	 * 保存用户信息
	 * @return
	 */
	public String save(){
		model.setId(UUID.randomUUID().toString());
		model.setRegtime(new Date());
		try {
			userService.save(model);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	/**
	 * 根据用户ID查询用户信息
	 * @return
	 */
	public String queryById(){
		User user=userService.get(model.getId());
		request.put("user", user);
		return "success";
	}
	
	/**
	 * 根据参数修改用户信息
	 * @return
	 */
	public String update(){
		model.setRegtime(new Date());
		userService.update(model);
		return "success";
	}

	/**
	 * 查询用户列表信息
	 * @return
	 */
	public String query(){
		List<User> list=userService.query();
		request.put("userList", list);
		return "success";
	}
	
	/**
	 * 根据ID删除用户信息 
	 * @return
	 */
	public String delete(){
		try {
			userService.delete(model.getId());
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}


}  
	
