package com.productapp.web.controller.beans;

public class PurchaseRequest {
	private Long storeId;
	private Long productid;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public PurchaseRequest() {
		super();
	}

}
