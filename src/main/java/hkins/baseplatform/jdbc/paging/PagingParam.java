package hkins.baseplatform.jdbc.paging;

import hkins.baseplatform.util.StringUtil;

public class PagingParam {
	
	private int offset;
	private int limit;
	private String search;
	private String sort;
	private String order;
	private String queryParams;
	private String query;
	
	public int getPagingNumber() {
		if(this.limit == 0) {
			return 1;
		}
		return this.offset / this.limit + 1;
	}
	
	public int getPageSize() {
		return this.limit;
	}
	
	public String getWhereCondition(String columnName) {
		return StringUtil.isNotEmpty(this.search) ? columnName + 
				"Like '%" + this.search + "%'" : null;
	}
	
	public String getOrderBy() {
		if (StringUtil.isNotEmpty(this.sort) || (StringUtil.isNotEmpty(this.order))) {
			return this.sort + " " + this.order.toUpperCase();
		}
		return null;
	}
	
	//Auto generated Getters and Setters 
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
