/**
 * @Author:jinshan.wang
 * @time:2018年6月4日上午10:53:00
 */
package com.sgl.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.web.context.request.async.WebAsyncManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.addressing.W3CAddressingMetadataConstants;

import antlr.StringUtils;
import freemarker.template.utility.StringUtil;

/**
 * @author jinshan.wang.it
 * @time   2018年6月4日上午10:53:00
 */
public class Test {
	//系统默认开始年份
	public static final String sYear="2017";
	//系统默认结束年份
	public static final String eYear="2018";

	public static StringBuffer  getData(String waName,String startYear,String endYear){


	    StringBuffer hsql= new StringBuffer();
	    hsql.append(" select b.wa_name waName,");
	    Integer yearSize=1;
	    Integer year=0;
	    if(null !=startYear && !"".equals(startYear) && null !=endYear && !"".equals(endYear) ){
	    	yearSize=yearSize+(Integer.parseInt(endYear)-Integer.parseInt(startYear));
	    	year=Integer.parseInt(startYear);
	    }else{
	    	yearSize=yearSize+(Integer.parseInt(eYear)-Integer.parseInt(sYear));
	    	year=Integer.parseInt(sYear);
	    }
	    for (int i=0; i<yearSize ; i++) {
		   year=year+i;
		   hsql.append(" (select sum(a1.sq) from irr_q_r a1 ");
           hsql.append(" where 1=1 ");
           hsql.append(" and a1.id=a.id ");
           hsql.append(" and datepart(yy,a1.btm)='"+year+"'");
           hsql.append(" ) extents"+i+",");
           hsql.append(year+" as year"+i);
           if(yearSize-i !=1){
        	   hsql.append(" ,");  
           }
	    }
	    hsql.append(" from irr_q_r a ");
        hsql.append(" left join IRR_ASSOCIATION_B b on a.assId=b.id ");
        hsql.append(" where 1=1 ");
	    if(null !=waName && !"".equals(waName)){
	       hsql.append(" and b.wa_name like '%"+waName+"%'");
	    }
         hsql.append(" group by a.assId ");

      return hsql;
	}
	
	
	
	public static void main(String[] args) {
		List<Map<String, Object>> fData=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> wnameList=new ArrayList<Map<String,Object>>();
		Map<String, Object> wnameData=new HashMap<String,Object>();
		wnameData.put("wname", "001村");
		Map<String, Object> ncwData=new HashMap<String,Object>();
		ncwData.put("小麦", 100);
		ncwData.put("大豆", 200);
		ncwData.put("高粱", 300);
		ncwData.put("玉米", 400);
		wnameList.add(ncwData);
		wnameData.put("znw_data", wnameList);
		fData.add(wnameData);
		wnameData=new HashMap<String,Object>();
		wnameData.put("wname", "002村");
		ncwData=new HashMap<String,Object>();
		ncwData.put("小麦", 221);
		ncwData.put("大豆", 332);
		ncwData.put("高粱", 443);
		ncwData.put("玉米", 232);
		wnameList=new ArrayList<Map<String,Object>>();
		wnameList.add(ncwData);
		wnameData.put("znw_data", wnameList);
		fData.add(wnameData);
		
		Map<String, Object> sdata=new HashMap<String,Object>();
		sdata.put("wname_data", fData);
		List<String> ncwlist = new ArrayList<String>();
		ncwlist.add("小麦");
		ncwlist.add("大豆");
		ncwlist.add("高粱");
		ncwlist.add("玉米");
		sdata.put("pnzw_data", ncwlist);
		Map<String, Object> data=new HashMap<String,Object>();
		data.put("data", sdata);
		System.out.println(JSONObject.toJSONString(data));
		
	}

}
