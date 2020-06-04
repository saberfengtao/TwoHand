package com.ft.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SaleOrder {
	private Integer soId;
	private BigDecimal soPrice;
	private int soNumber;
	private Timestamp soTimeStart;
	private Timestamp soTimeEnd;
	private int soState;
	private Good good;
	private GoodType goodType;
	private User outUser;
	private User inUser;
	public Integer getSoId() {
		return soId;
	}
	public void setSoId(Integer soId) {
		this.soId = soId;
	}
	public BigDecimal getSoPrice() {
		return soPrice;
	}
	public void setSoPrice(BigDecimal soPrice) {
		this.soPrice = soPrice;
	}
	public int getSoNumber() {
		return soNumber;
	}
	public void setSoNumber(int soNumber) {
		this.soNumber = soNumber;
	}
	public Timestamp getSoTimeStart() {
		return soTimeStart;
	}
	public void setSoTimeStart(Timestamp soTimeStart) {
		this.soTimeStart = soTimeStart;
	}
	public Timestamp getSoTimeEnd() {
		return soTimeEnd;
	}
	public void setSoTimeEnd(Timestamp soTimeEnd) {
		this.soTimeEnd = soTimeEnd;
	}
	public int getSoState() {
		return soState;
	}
	public void setSoState(int soState) {
		this.soState = soState;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public GoodType getGoodType() {
		return goodType;
	}
	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
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
		return "SaleOrder [soId=" + soId + ", soPrice=" + soPrice + ", soNumber=" + soNumber + ", soTimeStart="
				+ soTimeStart + ", soTimeEnd=" + soTimeEnd + ", soState=" + soState + ", good=" + good + ", goodType="
				+ goodType + ", outUser=" + outUser + ", inUser=" + inUser + "]";
	}
	
	
	
}
