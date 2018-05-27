package com.nba.service;

import com.alibaba.fastjson.JSONObject;
import com.nba.domain.Boxscore;
import com.nba.domain.Team;

public class NbaService {
	
	/**
	 * 通过gameJsonObject获取Boxscore比赛数据
	 * @param boxscoreJson
	 * @return
	 */
	public Boxscore getBoxscore(JSONObject gameJson){
		JSONObject boxscoreJson = gameJson.getJSONObject("boxscore");
		String statusDesc = boxscoreJson.getString("statusDesc");
		String periodClock = boxscoreJson.getString("periodClock");
		int awayScore = boxscoreJson.getIntValue("awayScore");
		int homeScore = boxscoreJson.getIntValue("homeScore");
		
		String seriesText = gameJson.getString("seriesText");
		
		Boxscore boxScore = new Boxscore(statusDesc,periodClock,homeScore,awayScore,seriesText);
		return boxScore;
	}
	
	/**
	 * 根据gameJsonObject获取比赛队伍
	 * @param gameJson
	 * @param type
	 * @return
	 */
	public Team getTeam(JSONObject gameJson,String type){
		
		JSONObject teamJson = gameJson.getJSONObject(type).getJSONObject("profile");
		String abbr = teamJson.getString("abbr");
		String city = teamJson.getString("city");
		String displayConference = teamJson.getString("displayConference");
		String name = teamJson.getString("name");
		
		String logoUrl = "http://china.nba.com/media/img/teams/logos/"+ abbr +"_logo.svg";
		
		Team team = new Team(abbr,city,displayConference,name,logoUrl,type);
		return team;
	}
	
}
