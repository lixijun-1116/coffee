package com.example.coffee;

import java.math.BigInteger;
import java.util.Date;


/**
 * 追踪面谈
 * 
 * @author dgl
 *
 */

public class TrackInterview {


	private int id;
	/**
	 * 关联的规划面谈id 
	 */
	private int planId;
	/**
	 * 外勤工号
	 */
	private String agentCode;
	/**
	 * 内勤工号
	 */
	private String userCode;
	/**
	 * 考核类型
	 */
	private String apprType;
	

	/**
	 * 追踪考核计划id
	 */
	private int apprPlanId;
	/**
	 * 追踪考核月份
	 */
	private int apprMonth;
	/**
	 * 追踪面谈时间
	 */
	private String apprTime;
	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 外勤IP
	 */
	private String agentIp;
	/**
	 * 外勤坐标
	 */
	private String agentCoordinate;
	/**
	 * 内勤IP
	 */
	private String userIp;
	/**
	 * 内勤坐标
	 */
	private String userCoordinate;
	/**
	 * 规划面谈状态
	 */
	private String planState;
	/**
	 * 操作时间
	 */
	private Date operateTime;
	//内勤是否确认0：未确认，1：已确认（默认值0）
	private int isUserConfirm;
	/**
	 * 外勤是否确认
	 */
	private int isAgentConfirm;
	//外勤页面进入时间
	private String agentEnterTime;
	//外勤页面离开时间
	private String agentLeaveTime;

	//基本制度达成指标Id，关联表GCCSIndex_EW..CurrMonthAgentApprPlan
	private int agentApprPlanId;
	//考核预警指标Json
	private String apprIndexJson;
	private String recordId;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getAgentEnterTime() {
		return agentEnterTime;
	}
	public void setAgentEnterTime(String agentEnterTime) {
		this.agentEnterTime = agentEnterTime;
	}
	public String getAgentLeaveTime() {
		return agentLeaveTime;
	}
	public void setAgentLeaveTime(String agentLeaveTime) {
		this.agentLeaveTime = agentLeaveTime;
	}

	public int getIsUserConfirm() {
		return isUserConfirm;
	}
	public void setIsUserConfirm(int isUserConfirm) {
		this.isUserConfirm = isUserConfirm;
	}

	//是否选择 0：未选择，1：已选择（默认值0）
	private int isSelected;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public String getApprTime() {
		return apprTime;
	}

	public void setApprTime(String apprTime) {
		this.apprTime = apprTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAgentIp() {
		return agentIp;
	}

	public void setAgentIp(String agentIp) {
		this.agentIp = agentIp;
	}

	public String getAgentCoordinate() {
		return agentCoordinate;
	}

	public void setAgentCoordinate(String agentCoordinate) {
		this.agentCoordinate = agentCoordinate;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserCoordinate() {
		return userCoordinate;
	}

	public void setUserCoordinate(String userCoordinate) {
		this.userCoordinate = userCoordinate;
	}

	public String getPlanState() {
		return planState;
	}

	public void setPlanState(String planState) {
		this.planState = planState;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public int getIsAgentConfirm() {
		return isAgentConfirm;
	}
	public void setIsAgentConfirm(int isAgentConfirm) {
		this.isAgentConfirm = isAgentConfirm;
	}
	public String getApprIndexJson() {
		return apprIndexJson; 
	}
	public void setApprIndexJson(String apprIndexJson) {
		this.apprIndexJson = apprIndexJson;
	}
	
	public int getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(int isSelected) {
		this.isSelected = isSelected;
	}
	public String getApprType() {
		return apprType;
	}
	public void setApprType(String apprType) {
		this.apprType = apprType;
	}
	public int getApprPlanId() {
		return apprPlanId;
	}
	public void setApprPlanId(int apprPlanId) {
		this.apprPlanId = apprPlanId;
	}
	public int getApprMonth() {
		return apprMonth;
	}
	public void setApprMonth(int apprMonth) {
		this.apprMonth = apprMonth;
	}
	public int getAgentApprPlanId() {
		return agentApprPlanId;
	}
	public void setAgentApprPlanId(int agentApprPlanId) {
		this.agentApprPlanId = agentApprPlanId;
	}

}
