package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductserviceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductService service = new ProductserviceImpl();
		List<ProductVO> list =  service.ProductSelectList();
		
		request.setAttribute("list", list);
		
		return "product/productList.tiles";
	}

}
