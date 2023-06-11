package com.TodoList.TodoList.dto;

import java.sql.Date;

//import javax.management.relation.Role;

public class Todo {
//	private Integer roleId;
//	private String description;
	
	private long id;
	private String title;
	private String name;
	private String sequence;
	private String type;
	private Date regdate;
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", name=" + name + ", sequence=" + sequence + ", type=" + type
				+ ", regdate=" + regdate + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	
	
	
	//여기까지
	
	
	
//	public Todo(Integer roleId, String description) {
//		super();
//		this.roleId = roleId;
//		this.description = description;
//	}
//	public Integer getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(Integer roleId) {
//		this.roleId = roleId;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
//	@Override
//	public String toString() {
//		return "Todo [roleId=" + roleId + ", description=" + description + "]";
//	}
	
}
