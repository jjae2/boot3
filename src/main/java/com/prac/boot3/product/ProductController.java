package com.prac.boot3.product;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.prac.boot3.board.BoardVO;
import com.prac.boot3.member.MemberVO;
import com.prac.boot3.util.Pager;

@Controller
@RequestMapping("product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("detail")
	public ModelAndView getDetail(ProductVO productVO)throws Exception{
		//파라미터 productNum
		//모든 구매자가 보는 페이지
		ModelAndView mv =new ModelAndView();
		productVO =productService.getDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/detail");
		return mv;
	}
	
	@GetMapping("manageDetail")
	public ModelAndView getManageDetail(ProductVO productVO)throws Exception{
		//파라미터 productNum
		//모든 판매자가 보는 페이지
		ModelAndView mv =new ModelAndView();
		productVO= productService.getDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/manageDetail");
		return mv;
	}
	
	@GetMapping("manage")
	public ModelAndView manage(Pager pager, HttpSession session)throws Exception{
		ModelAndView mv =new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		
		List<ProductVO>ar =productService.getList(pager);
		mv.addObject("list",ar);
		mv.setViewName("product/manage");
		return mv;
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager,ProductVO productVO)throws Exception{
		ModelAndView mv= new ModelAndView();
		List<ProductVO> ar =productService.getList(pager);
		mv.addObject("list",ar);
		mv.setViewName("product/list");
		mv.addObject("pager",pager); 
		return mv;
	}
	@GetMapping("add")
	 public ModelAndView setAdd(@ModelAttribute ProductVO productVO)throws Exception{
		ModelAndView mv =new ModelAndView();
		mv.setViewName("product/add");
	    return mv;
	}
	@PostMapping("add")
	public ModelAndView setAdd(@Valid ProductVO productVO,BindingResult bindingResult,MultipartFile[] files, HttpSession session)throws Exception{
		ModelAndView mv =new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("product/add");
			return mv;
		}
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());
		int result=productService.setAdd(productVO,files);
		mv.setViewName("common/result2");
		mv.addObject("result",result);
		return mv;
	}
	@GetMapping("update")
	   public ModelAndView setUpdate(ProductVO productVO)throws Exception{
		   ModelAndView mv =new ModelAndView();
		   productVO=productService.getDetail(productVO);
		   mv.addObject("vo",productVO);
		   mv.setViewName("product/update");
		   
		   return mv;
	   }
	   @PostMapping("update")
	   public ModelAndView setUpdate(ProductVO productVO,MultipartFile[] files)throws Exception{
		   ModelAndView mv =new ModelAndView();
		   int result=productService.setUpdate(productVO,files);	   
		   if(result>0) {
			   mv.setViewName("redirect:./manage");
		   }else {
			   mv.setViewName("common/getResult");
			   mv.addObject("msg","업데이트 실패 했습니다.");
			   mv.addObject("path","./manageDetail?productNum="+productVO.getProductNum());
		   }
		   return mv;
	   } 
	
	@GetMapping("ajaxList")
	public ModelAndView getAjaxList(Pager pager,HttpSession session)throws Exception{
		ModelAndView mv =new ModelAndView();
		MemberVO memberVO= (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("common/productList");
		return mv;
	}
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(ProductFilesVO productFilesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = productService.setFileDelete(productFilesVO);
		//System.out.println(productFilesVO.getFileNum());
	
		mv.addObject("result",result);	//0 또는 1보냄
		mv.setViewName("common/result2");
		return mv;
	}
	
}
