package com.sinosoft.dms.api.billno.dto;

import java.io.Serializable;

public class BillNoCDDto implements Serializable {
	
	 	private String tableName;
	    private String riskCode;
	    private String iComCode;
	    private int iYear;
	    private String SessionId;
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public String getRiskCode() {
			return riskCode;
		}
		public void setRiskCode(String riskCode) {
			this.riskCode = riskCode;
		}
		public String getiComCode() {
			return iComCode;
		}
		public void setiComCode(String iComCode) {
			this.iComCode = iComCode;
		}
		public int getiYear() {
			return iYear;
		}
		public void setiYear(int iYear) {
			this.iYear = iYear;
		}
		public String getSessionId() {
			return SessionId;
		}
		public void setSessionId(String sessionId) {
			SessionId = sessionId;
		}
	    

}
