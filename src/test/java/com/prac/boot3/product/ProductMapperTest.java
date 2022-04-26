package com.prac.boot3.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac.boot3.util.Pager;


@SpringBootTest
class ProductMapperTest {
	@Autowired
	private ProductMapper productMapper;

	//@Test
	void getListTest() throws Exception{
		Pager pager =new Pager();
		pager.makeRow();
		pager.makeNum(productMapper.getTotalCount(pager));
		List<ProductVO> ar =productMapper.getList(pager);
		
		assertNotNull(ar);
	}
//	//@Test
//	void getListTest() throws Exception{
//	      Pager pager = new Pager();
//	      pager.makeRow();
//	      List<BoardVO> ar=boardMapper.getList(pager);
//	      
//	      System.out.println(ar);
//	      assertEquals(10,ar.size());
//	   }

	@Test
	void addTest() throws Exception {
		for(int i=0; i<101; i++) {
			ProductVO productVO =new ProductVO();
			productVO.setProductName("name"+i);
			productVO.setProductPrice(3000L+i);
			productVO.setProductCount(1L+i);
			productVO.setProductDetail("detail");
			int result = productMapper.setAdd(productVO);
		}
		/* assertEquals(1, result); */
		
	}

//	// @Test
//	void UpdateTest() throws Exception {
//
//		BoardVO boardVO = new BoardVO();
//		boardVO.setNum(4L);
//		boardVO.setContents("contents update!!");
//		int result = boardMapper.setUpdate(boardVO);
//		assertEquals(1, result);
//	}
//
//	// @Test
//	void DeleteTest() throws Exception {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setNum(4L);
//
//		int result = boardMapper.setDelete(boardVO);
//		assertEquals(1, result);
//	}
//
//	// @Test
//	void setFileAddTest() throws Exception {
//		BoardFilesVO boardFilesVO = new BoardFilesVO();
//		boardFilesVO.setFileName("filename");
//		boardFilesVO.setOriName("oriname");
//		boardFilesVO.setNum(3L);
//		int result = boardMapper.setFileAdd(boardFilesVO);
//		assertEquals(1, result);
//	}
}
