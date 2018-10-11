package com.sinosoft.agriprpall.api.client.dto;
/**
 * 恐怖信息查询请求信息
 * @author Administrator
 *
 */
public class RequestQueryTerroristInfoDto {

	/**页码*/
	private Integer pageNo;
	/**每页条数*/
	private Integer pageSize;

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

}
