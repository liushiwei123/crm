package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

public class CustomerServeQuery extends BaseQuery{

	private String state;
	
	private String serveType;
	private String customer;
	
	

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
