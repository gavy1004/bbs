package com.yedam.notice.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DBCommand;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 (id, title, content)
		// serviceImpl -> updata 기능작성
		// 공지사랑 리스트로 페이지 호출
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		vo.setTitle(title);
		vo.setContent(content);
	
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		service.updateNotice(vo);
		
		request.setAttribute("notice", vo);
		
		NoticeList commad = new NoticeList();
		commad.execute(request, response);
		
		return "/noticeListPaging.do";

	}

}
