package com.shsxt.crm.dto;

import java.util.ArrayList;
import java.util.List;

public class TreeDto {
	
	private Integer id;
	
	private Integer pId;
	
	private String name;
	
	
	private String url;
	
	private Boolean checked=false;
	
	
	private List<TreeDto> children=new ArrayList<TreeDto>();
	
	
	
	
	
	
	

	public List<TreeDto> getChildren() {
		return children;
	}

	public void setChildren(List<TreeDto> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
