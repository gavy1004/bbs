package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductserviceImpl;

import oracle.jdbc.internal.XSSessionNamespace;

public class IndexPage implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	      
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("id");
	      
	      ProductserviceImpl service1 = new ProductserviceImpl();
	      int cartCnt = service1.getCountCart(id);
	      
	      request.setAttribute("id", id);
	      request.setAttribute("cartCnt", cartCnt);
	      
	      return "common/section.tiles";

	}

}
