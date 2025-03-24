package com.ibm.ivia.config.model;

public class PasswordPolicy {
	private String enable;
	private String lockDuration;
	private String minLenth;	
	private String maxFailures;
	private boolean noSpace;
	private boolean noUserId;
	private String loginAttributeId;
	private String minLower;
	private String minUpper;
	private String minSpecial;
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getLockDuration() {
		return lockDuration;
	}
	public void setLockDuration(String lockDuration) {
		this.lockDuration = lockDuration;
	}
	public String getMinLenth() {
		return minLenth;
	}
	public void setMinLenth(String minLenth) {
		this.minLenth = minLenth;
	}
	public String getMaxFailures() {
		return maxFailures;
	}
	public void setMaxFailures(String maxFailures) {
		this.maxFailures = maxFailures;
	}
	public boolean isNoSpace() {
		return noSpace;
	}
	public void setNoSpace(boolean noSpace) {
		this.noSpace = noSpace;
	}
	public boolean isNoUserId() {
		return noUserId;
	}
	public void setNoUserId(boolean noUserId) {
		this.noUserId = noUserId;
	}
	public String getLoginAttributeId() {
		return loginAttributeId;
	}
	public void setLoginAttributeId(String loginAttributeId) {
		this.loginAttributeId = loginAttributeId;
	}
	public String getMinLower() {
		return minLower;
	}
	public void setMinLower(String minLower) {
		this.minLower = minLower;
	}
	public String getMinUpper() {
		return minUpper;
	}
	public void setMinUpper(String minUpper) {
		this.minUpper = minUpper;
	}
	public String getMinSpecial() {
		return minSpecial;
	}
	public void setMinSpecial(String minSpecial) {
		this.minSpecial = minSpecial;
	}
	@Override
	public String toString() {
		return "PasswordPolicy [enable=" + enable + ", lockDuration=" + lockDuration + ", minLenth=" + minLenth
				+ ", maxFailures=" + maxFailures + ", noSpace=" + noSpace + ", noUserId=" + noUserId
				+ ", loginAttributeId=" + loginAttributeId + ", minLower=" + minLower + ", minUpper=" + minUpper
				+ ", minSpecial=" + minSpecial + "]";
	}
	
}