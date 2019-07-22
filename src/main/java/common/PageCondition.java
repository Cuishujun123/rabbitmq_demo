package common;

import java.io.Serializable;

public class PageCondition implements Serializable{

	private static final long serialVersionUID = 6158207311168692364L;

	private Integer pageNo = 1;
	
	private Integer pageSize = 6;
	
	private Integer offset;
	
	private Integer count;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getOffset() {
		return (getPageNo() - 1) * getPageSize();
	}

	public Integer getCount() {
		return getPageSize();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageCondition [pageNo=").append(pageNo).append(", pageSize=").append(pageSize).append("]");
		return builder.toString();
	}
}
