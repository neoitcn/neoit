package com.qixin.neoit.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 由前台的jqGrid传参的分页对象

 */
public class Page {

	private Integer rows;// 每页显示几行记录
	private Long page;// 当前页为第几页
	private String sort = "ASC";// 排序规则
	private Integer start; // 从某条 记录开始查询

	private Map<String, Object> param = new HashMap<>(); // 该参数为分页所需的参数

	private String loginName;// 当前登录用户

	public Integer getRows() {
		if (rows == null || rows <= 0) {
			rows = -1;
		}
		return rows;
	}

	public void setRows(Integer rows) {
		if (rows == null || rows <= 0) {
			rows = -1;
		}
		this.rows = rows;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getStart() {
		Integer start = null;
		if (page != null && rows != null) {
			start = (int)(page - 1) * rows;
		}
		if (start == null || start < 0) {
			start = 0;
		}
		return start;
	}

	public void setStart(Integer start) {
		if (start == null) {
			start = 0;
		}
		this.start = start;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

}
