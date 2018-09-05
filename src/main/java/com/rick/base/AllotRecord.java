package com.rick.base;

import java.util.Date;
   /**
    * allot_record 实体类
    * luxue
    */ 


public class AllotRecord extends BaseEntity{
	private String workerId;
	private int outTeamId;
	private Date outTime;
	private int inTeamId;
	private Date inTime;
	private Date crTime;
	private Date upTime;
	private int isActive;
	public void setWorkerId(String workerId){
	this.workerId=workerId;
	}
	public String getWorkerId(){
		return workerId;
	}
	public void setOutTeamId(int outTeamId){
	this.outTeamId=outTeamId;
	}
	public int getOutTeamId(){
		return outTeamId;
	}
	public void setOutTime(Date outTime){
	this.outTime=outTime;
	}
	public Date getOutTime(){
		return outTime;
	}
	public void setInTeamId(int inTeamId){
	this.inTeamId=inTeamId;
	}
	public int getInTeamId(){
		return inTeamId;
	}
	public void setInTime(Date inTime){
	this.inTime=inTime;
	}
	public Date getInTime(){
		return inTime;
	}
	public void setCrTime(Date crTime){
	this.crTime=crTime;
	}
	public Date getCrTime(){
		return crTime;
	}
	public void setUpTime(Date upTime){
	this.upTime=upTime;
	}
	public Date getUpTime(){
		return upTime;
	}
	public void setIsActive(int isActive){
	this.isActive=isActive;
	}
	public int getIsActive(){
		return isActive;
	}
}

