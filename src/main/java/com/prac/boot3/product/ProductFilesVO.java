package com.prac.boot3.product;

import com.prac.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProductFilesVO extends FileVO {
	
	private Long productNum;

}
