package com.nba.domain;

public class Team {
	
	private String abbr;		//英文缩写，用于获取logo
	private String city;		//城市
	private String displayConference;	//东西部
	private String name;		//名称
	private String logoUrl;
	private String awayOrHome;	//此次比赛中这球队是主场还是客场
	
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDisplayConference() {
		return displayConference;
	}
	public void setDisplayConference(String displayConference) {
		this.displayConference = displayConference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAwayOrHome() {
		return awayOrHome;
	}
	public void setAwayOrHome(String awayOrHome) {
		this.awayOrHome = awayOrHome;
	}
	
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public Team() {
		super();
	}
	public Team(String abbr, String city, String displayConference, String name, String logoUrl, String awayOrHome) {
		super();
		this.abbr = abbr;
		this.city = city;
		this.displayConference = displayConference;
		this.name = name;
		this.logoUrl = logoUrl;
		this.awayOrHome = awayOrHome;
	}
	@Override
	public String toString() {
		return "Team [abbr=" + abbr + ", city=" + city + ", displayConference=" + displayConference + ", name=" + name
				+ ", logoUrl=" + logoUrl + ", awayOrHome=" + awayOrHome + "]";
	}

}
