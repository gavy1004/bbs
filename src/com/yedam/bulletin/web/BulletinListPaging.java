package com.yedam.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DBCommand;
import com.yedam.common.Paging;

public class BulletinListPaging implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");	// 페이지번호
		
		if(page == null) 
			page= "1";
		
		int pageCnt = Integer.parseInt(page);
		
		BulletinServiceImpl service = new BulletinServiceImpl();
		List<BulletinVO> total =  service.bulletinSelectList();	//	 전체 카운트
		
		service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulletinListPaging(pageCnt);
		
		
        Paging paging = new Paging();
        paging.setPageNo(pageCnt);
        paging.setPageSize(10);
        paging.setTotalCount(total.size());

        request.setAttribute("paging", paging);
        request.setAttribute("bulletinList", list);
        
		return "bulletin/bulletinListPaging.tiles";
	}

}
