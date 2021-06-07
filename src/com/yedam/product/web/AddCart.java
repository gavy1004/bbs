package com.yedam.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DBCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductserviceImpl;

public class AddCart implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// cart 테이블에 한건 추가 (회원아이디, 상품정보, 수량(=1)
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("id");
		 
		String id = request.getParameter("id");
		String itemCode = request.getParameter("itemCode");
		int qty = 1; // 수량

		ProductserviceImpl service = new ProductserviceImpl();
		service.addCart(id, itemCode, qty);

		ProductserviceImpl service1 = new ProductserviceImpl();
		int cartCnt = service1.getCountCart(id);
		
		session.setAttribute("uid", uid);
		session.setAttribute("cartCnt", cartCnt);

		return "/index.do";
	      // cart table에 1건 추가(화원 id, 상품 정보, 수량->1)

	}
}
