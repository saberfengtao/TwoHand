package com.ft.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PurchaseOrder {
	private Integer poId;
	private BigDecimal poPrice;
	private int poNumber;
	private Timestamp poTimeStart;
	private Timestamp poTimeEnd;
	private int poState;
	private Good good;
	private User outUser;
	private User inUser;
	
	public Integer getPoId() {
		return poId;
	}
	public void setPoId(Integer poId) {
		this.poId = poId;
	}
	public BigDecimal getPoPrice() {
		return poPrice;
	}
	public void setPoPrice(BigDecimal poPrice) {
		this.poPrice = poPrice;
	}
	public int getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}
	public Timestamp getPoTimeStart() {
		return poTimeStart;
	}
	public void setPoTimeStart(Timestamp poTimeStart) {
		this.poTimeStart = poTimeStart;
	}
	public Timestamp getPoTimeEnd() {
		return poTimeEnd;
	}
	public void setPoTimeEnd(Timestamp poTimeEnd) {
		this.poTimeEnd = poTimeEnd;
	}
	public int getPoState() {
		return poState;
	}
	public void setPoState(int poState) {
		this.poState = poState;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public User getOutUser() {
		return outUser;
	}
	public void setOutUser(User outUser) {
		this.outUser = outUser;
	}
	public User getInUser() {
		return inUser;
	}
	public void setInUser(User inUser) {
		this.inUser = inUser;
	}
	
	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", poPrice=" + poPrice + ", poNumber=" + poNumber + ", poTimeStart="
				+ poTimeStart + ", poTimeEnd=" + poTimeEnd + ", poState=" + poState + ", good=" + good + ", outUser="
				+ outUser + ", inUser=" + inUser + "]";
	}

}
