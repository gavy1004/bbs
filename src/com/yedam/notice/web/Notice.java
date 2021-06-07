package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class Notice implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한건 조회 -> 상세화면에 보여주기 
		// serviceImpl구현
		String id =request.getParameter("id");
		System.out.println(id);
		if(id== null)
			id="0";
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		service.noticeSelect(vo);
		
		request.setAttribute("notice", vo);
		return "notice/notice.tiles";
	}

}
