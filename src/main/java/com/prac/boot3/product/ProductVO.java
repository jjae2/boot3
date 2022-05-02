package com.prac.boot3.product;

import java.util.List;

import lombok.Data;

@Data
public class ProductVO {
	private Long productNum;
	private String productName;
	private Long productPrice;
	private Long productCount;
	private String productDetail;
	private int sale;
	private String id;
	private List<ProductFilesVO> productFilesVO;
}
