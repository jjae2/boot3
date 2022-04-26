package com.prac.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.prac.boot3.util.FileManager;
import com.prac.boot3.util.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;

	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(productMapper.getTotalCount(pager));
		return productMapper.getList(pager);
	}

	public int setAdd(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productMapper.setAdd(productVO);
		if (files != null) {
			for (MultipartFile mf : files) {
				if (mf.isEmpty()) {
					continue;
				}
				// 1.HDD에 저장
				String fileName = fileManager.fileSave(mf, "resources/upload/product/");
				System.out.println(fileName);
				// 2. DB에 저장
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(mf.getOriginalFilename());

				productMapper.setFileAdd(productFilesVO);

			}
		}
		return result;
	}

}
