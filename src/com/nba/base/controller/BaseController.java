package com.nba.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {
	
	protected Map<String, Object> FailJson(String msg){
		Map<String,Object> resultJson = new HashMap<String,Object>();
		resultJson.put("code", "0");
		resultJson.put("msg", msg);
		return resultJson;
	}
	
	
	protected Map<String, Object> SuccessJson(List<Map<String,Object>> list){
		Map<String,Object> resultJson = new HashMap<String,Object>();
		resultJson.put("code", "1");
		resultJson.put("games", list);

		return resultJson;
	}
	
}
