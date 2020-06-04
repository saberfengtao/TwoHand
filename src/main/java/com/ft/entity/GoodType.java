package com.ft.entity;

public class GoodType {
	private Integer goodTypeId;
	private String goodTypeName;
	private int goodTypeState;
	
	public Integer getGoodTypeId() {
		return goodTypeId;
	}
	public void setGoodTypeId(Integer goodTypeId) {
		this.goodTypeId = goodTypeId;
	}
	public String getGoodTypeName() {
		return goodTypeName;
	}
	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}
	public int getGoodTypeState() {
		return goodTypeState;
	}
	public void setGoodTypeState(int goodTypeState) {
		this.goodTypeState = goodTypeState;
	}
	
	@Override
	public String toString() {
		return "GoodType [goodTypeId=" + goodTypeId + ", goodTypeName=" + goodTypeName + ", goodTypeState="
				+ goodTypeState + "]";
	}
	
}
