package hkins.baseplatform.jdbc.paging;

import java.util.List;

public class PagingResult<T> {
	
	private List<T> rows;
	private long total;
	
	public PagingResult(Paging<T> paging) {
		this.rows = paging.getItemList();
		this.total = paging.getTotalCount();
	}
	
	//Auto Generated Getters and Setters
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
