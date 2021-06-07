package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DBCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductserviceImpl;
import com.yedam.product.vo.ProductVO;

public class CartList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ProductVO vo = new ProductVO();
		vo.setUserId(id);

		ProductService service = new ProductserviceImpl();
		List<ProductVO> list = service.CartSelect(vo);
		
		request.setAttribute("cartList", list);
		return "product/cartList.tiles";
	}

}
