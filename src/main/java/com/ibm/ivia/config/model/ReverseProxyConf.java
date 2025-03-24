package com.ibm.ivia.config.model;

import java.util.List;

public class ReverseProxyConf {

	private List<RequestConfig> rpConf;
	private String repoUrl;
	private String imageVersion;
	public List<RequestConfig> getRpConf() {
		return rpConf;
	}
	public void setRpConf(List<RequestConfig> rpConf) {
		this.rpConf = rpConf;
	}
	public String getRepoUrl() {
		return repoUrl;
	}
	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}
	public String getImageVersion() {
		return imageVersion;
	}
	public void setImageVersion(String imageVersion) {
		this.imageVersion = imageVersion;
	}
	
	
	
}
