package com.freshen.entity;

import java.util.Date;

public class ViewOrderInfo {
	String orderid_s;
    Date reservationdate_t;
    int status_i;
    String customerid_s;
    Date startdate_d,enddate_d;
    String customeruserid_s,capguserid_s,invoiceorder_s,addedvaluetax_s,invoiceuser_s;
    Date actualdate_d,createdate_t;
    String createuser_s,lastupdateuser_s;
    Date lastupdatedate_t;
    String resaveds1_s,resaveds2_s,resaveds3_s,resaveds4_s,resaveds5_s;
    String receiverlnvoiceaddress_s,invoiceuserphone_s,ordername_s;
    Integer ispotential;
    //sharonyshi 2014-10-31
    String customerName_s;
    
    
    
    
	public String getCustomerName_s() {
		return customerName_s;
	}
	public void setCustomerName_s(String customerName_s) {
		this.customerName_s = customerName_s;
	}
	public String getOrderid_s() {
		return orderid_s;
	}
	public void setOrderid_s(String orderid_s) {
		this.orderid_s = orderid_s;
	}
	public Date getReservationdate_t() {
		return reservationdate_t;
	}
	public void setReservationdate_t(Date reservationdate_t) {
		this.reservationdate_t = reservationdate_t;
	}
	public int getStatus_i() {
		return status_i;
	}
	public void setStatus_i(int status_i) {
		this.status_i = status_i;
	}
	public String getCustomerid_s() {
		return customerid_s;
	}
	public void setCustomerid_s(String customerid_s) {
		this.customerid_s = customerid_s;
	}
	public Date getStartdate_d() {
		return startdate_d;
	}
	public void setStartdate_d(Date startdate_d) {
		this.startdate_d = startdate_d;
	}
	public Date getEnddate_d() {
		return enddate_d;
	}
	public void setEnddate_d(Date enddate_d) {
		this.enddate_d = enddate_d;
	}
	public String getCustomeruserid_s() {
		return customeruserid_s;
	}
	public void setCustomeruserid_s(String customeruserid_s) {
		this.customeruserid_s = customeruserid_s;
	}
	public String getCapguserid_s() {
		return capguserid_s;
	}
	public void setCapguserid_s(String capguserid_s) {
		this.capguserid_s = capguserid_s;
	}
	public String getInvoiceorder_s() {
		return invoiceorder_s;
	}
	public void setInvoiceorder_s(String invoiceorder_s) {
		this.invoiceorder_s = invoiceorder_s;
	}
	public String getAddedvaluetax_s() {
		return addedvaluetax_s;
	}
	public void setAddedvaluetax_s(String addedvaluetax_s) {
		this.addedvaluetax_s = addedvaluetax_s;
	}
	public String getInvoiceuser_s() {
		return invoiceuser_s;
	}
	public void setInvoiceuser_s(String invoiceuser_s) {
		this.invoiceuser_s = invoiceuser_s;
	}
	public Date getActualdate_d() {
		return actualdate_d;
	}
	public void setActualdate_d(Date actualdate_d) {
		this.actualdate_d = actualdate_d;
	}
	public Date getCreatedate_t() {
		return createdate_t;
	}
	public void setCreatedate_t(Date createdate_t) {
		this.createdate_t = createdate_t;
	}
	public String getCreateuser_s() {
		return createuser_s;
	}
	public void setCreateuser_s(String createuser_s) {
		this.createuser_s = createuser_s;
	}
	public String getLastupdateuser_s() {
		return lastupdateuser_s;
	}
	public void setLastupdateuser_s(String lastupdateuser_s) {
		this.lastupdateuser_s = lastupdateuser_s;
	}
	public Date getLastupdatedate_t() {
		return lastupdatedate_t;
	}
	public void setLastupdatedate_t(Date lastupdatedate_t) {
		this.lastupdatedate_t = lastupdatedate_t;
	}
	public String getResaveds1_s() {
		return resaveds1_s;
	}
	public void setResaveds1_s(String resaveds1_s) {
		this.resaveds1_s = resaveds1_s;
	}
	public String getResaveds2_s() {
		return resaveds2_s;
	}
	public void setResaveds2_s(String resaveds2_s) {
		this.resaveds2_s = resaveds2_s;
	}
	public String getResaveds3_s() {
		return resaveds3_s;
	}
	public void setResaveds3_s(String resaveds3_s) {
		this.resaveds3_s = resaveds3_s;
	}
	public String getResaveds4_s() {
		return resaveds4_s;
	}
	public void setResaveds4_s(String resaveds4_s) {
		this.resaveds4_s = resaveds4_s;
	}
	public String getResaveds5_s() {
		return resaveds5_s;
	}
	public void setResaveds5_s(String resaveds5_s) {
		this.resaveds5_s = resaveds5_s;
	}
	public String getReceiverlnvoiceaddress_s() {
		return receiverlnvoiceaddress_s;
	}
	public void setReceiverlnvoiceaddress_s(String receiverlnvoiceaddress_s) {
		this.receiverlnvoiceaddress_s = receiverlnvoiceaddress_s;
	}
	public String getInvoiceuserphone_s() {
		return invoiceuserphone_s;
	}
	public void setInvoiceuserphone_s(String invoiceuserphone_s) {
		this.invoiceuserphone_s = invoiceuserphone_s;
	}
	public String getOrdername_s() {
		return ordername_s;
	}
	public void setOrdername_s(String ordername_s) {
		this.ordername_s = ordername_s;
	}
	
	public Integer getIspotential() {
		return ispotential;
	}
	public void setIspotential(Integer ispotential) {
		this.ispotential = ispotential;
	}
	@Override
	public String toString() {
		return "ViewOrderInfo [orderid_s=" + orderid_s + ", reservationdate_t="
				+ reservationdate_t + ", status_i=" + status_i
				+ ", customerid_s=" + customerid_s + ", startdate_d="
				+ startdate_d + ", enddate_d=" + enddate_d
				+ ", customeruserid_s=" + customeruserid_s + ", capguserid_s="
				+ capguserid_s + ", invoiceorder_s=" + invoiceorder_s
				+ ", addedvaluetax_s=" + addedvaluetax_s + ", invoiceuser_s="
				+ invoiceuser_s + ", actualdate_d=" + actualdate_d
				+ ", createdate_t=" + createdate_t + ", createuser_s="
				+ createuser_s + ", lastupdateuser_s=" + lastupdateuser_s
				+ ", lastupdatedate_t=" + lastupdatedate_t + ", resaveds1_s="
				+ resaveds1_s + ", resaveds2_s=" + resaveds2_s
				+ ", resaveds3_s=" + resaveds3_s + ", resaveds4_s="
				+ resaveds4_s + ", resaveds5_s=" + resaveds5_s
				+ ", receiverlnvoiceaddress_s=" + receiverlnvoiceaddress_s
				+ ", invoiceuserphone_s=" + invoiceuserphone_s
				+ ", ordername_s=" + ordername_s + ", ispotential="
				+ ispotential + "]";
	}
    
    
}
