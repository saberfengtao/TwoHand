package com.ft.entity;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class Good {
	private Integer goodId;
	private String goodName;
	private Integer goodCount;
	private BigDecimal goodPrice;
	private String goodPhoto;
	private MultipartFile filePath;//物品照片路径
	private String goodIntroduction;
	private int goodState;
	private GoodType goodType;
	
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Integer getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodPhoto() {
		return goodPhoto;
	}
	public void setGoodPhoto(String goodPhoto) {
		this.goodPhoto = goodPhoto;
	}
	public String getGoodIntroduction() {
		return goodIntroduction;
	}
	public void setGoodIntroduction(String goodIntroduction) {
		this.goodIntroduction = goodIntroduction;
	}
	public int getGoodState() {
		return goodState;
	}
	public void setGoodState(int goodState) {
		this.goodState = goodState;
	}
	public GoodType getGoodType() {
		return goodType;
	}
	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}

	public MultipartFile getFilePath() {
		return filePath;
	}

	public void setFilePath(MultipartFile filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Good{" +
				"goodId=" + goodId +
				", goodName='" + goodName + '\'' +
				", goodCount=" + goodCount +
				", goodPrice=" + goodPrice +
				", goodPhoto='" + goodPhoto + '\'' +
				", filePath=" + filePath +
				", goodIntroduction='" + goodIntroduction + '\'' +
				", goodState=" + goodState +
				", goodType=" + goodType +
				'}';
	}
}
