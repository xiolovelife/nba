package com.nba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nba.base.controller.BaseController;
import com.nba.domain.Boxscore;
import com.nba.domain.Team;
import com.nba.service.NbaService;
import com.nba.util.HttpClientUtil;

@Controller
public class NbaController extends BaseController{
	
	private final String url = "http://china.nba.com/static/data/scores/miniscoreboardlive.json";
	
	private NbaService nbaService = new NbaService();
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/today",method= RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> today(ModelMap modelMap,HttpServletRequest request){
		
		JSONObject result = HttpClientUtil.doGet(url);
		
		String err = result.getJSONObject("error").getString("isError");
		if( !err.equals("false") ){
			return FailJson("服务异常，请耐心等候修复");
		}
		
		JSONObject payload =  result.getJSONObject("payload");
		JSONObject today = payload.getJSONObject("today");
		
		JSONArray arr = today.getJSONArray("games");
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		for( int i = 0; i < arr.size(); i++ ){
			
			JSONObject gameJson = (JSONObject) today.getJSONArray("games").get(i);
			Map<String,Object> map = new HashMap<String,Object>();
			
			//比赛数据
			Boxscore boxscore = nbaService.getBoxscore(gameJson);
			map.put("boxscore", boxscore);
			
			//球队
			Team homeTeam =  nbaService.getTeam(gameJson, "homeTeam");
			Team awayTeam = nbaService.getTeam(gameJson, "awayTeam");
			map.put("homeTeam", homeTeam);
			map.put("awayTeam", awayTeam);
			
			list.add(map);
		}
		
		return SuccessJson(list);
	}
}
