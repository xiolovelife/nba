package com.nba.domain;

public class Boxscore {
	
	private String statusDesc;	//第几节
	private String periodClock;	//这节第几分钟
	
	private int homeScore;	//主场球队分数
	private int awayScore;	//客场球队分数
	
	private String seriesText;	//总比分

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getPeriodClock() {
		return periodClock;
	}

	public void setPeriodClock(String periodClock) {
		this.periodClock = periodClock;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public String getSeriesText() {
		return seriesText;
	}

	public void setSeriesText(String seriesText) {
		this.seriesText = seriesText;
	}

	public Boxscore() {
		super();
	}

	public Boxscore(String statusDesc, String periodClock, int homeScore, int awayScore, String seriesText) {
		super();
		this.statusDesc = statusDesc;
		this.periodClock = periodClock;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.seriesText = seriesText;
	}

	@Override
	public String toString() {
		return "Boxscore [statusDesc=" + statusDesc + ", periodClock=" + periodClock + ", homeScore=" + homeScore
				+ ", awayScore=" + awayScore + ", seriesText=" + seriesText + "]";
	}
	
	
}
