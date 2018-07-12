package com.sgl.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sgl.model.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	private static final long serialVersionUID = 1L;
	
	@Value("${test_url}")
	private String test_url;
	
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name="queueDestination")
    private Destination destination;
	
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
		final Long itemId=1000L;
    	jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(itemId+"");
				return textMessage;
			}
		});
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
	
	
	public String hightchats(){
		String wName;
		String sYear;
		String eYear;
		Map<String, Object> dataMap=new HashMap<String,Object>();
		//存储wanameList
		List<Map<String, String>> wNameMap= new ArrayList<Map<String,String>>();
		//单个存储wanme
		Map<String, String> itemWnameMap=new HashMap<String,String>();
		itemWnameMap.put("id", "001");
		itemWnameMap.put("waName", "大脸一村");
		wNameMap.add(itemWnameMap);
		itemWnameMap=new HashMap<String,String>();
		itemWnameMap.put("id", "002");
		itemWnameMap.put("waName", "B");
		wNameMap.add(itemWnameMap);
		itemWnameMap=new HashMap<String,String>();
		itemWnameMap.put("id", "003");
		itemWnameMap.put("waName", "C");
		wNameMap.add(itemWnameMap);
		dataMap.put("data", wNameMap);
		//存储item
		List<Map<String, Object>> itemMap= new ArrayList<Map<String,Object>>();
		Map<String, Object> data=new HashMap<String,Object>();
		Map<String, Object> itemSumSq=new HashMap<String,Object>();
		itemSumSq.put("A", 100);
		itemSumSq.put("B", 200);
		itemSumSq.put("C", 300);
		data.put("year", "2017");
		data.put("data", itemSumSq);
		itemMap.add(data);
		data=new HashMap<String,Object>();
		itemSumSq=new HashMap<String,Object>();
		itemSumSq.put("A", 100);
		itemSumSq.put("B", 200);
		itemSumSq.put("C", 300);
		data.put("year", "2018");
		data.put("data", itemSumSq);
		itemMap.add(data);
		dataMap.put("items", itemMap);
		request.put("data", JSONObject.toJSON(dataMap));
		request.put("title", "大脸村用水情况");
		request.put("subtitle", "她是一个胖子");
		return "success";
	}


}  
	
