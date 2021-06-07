package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.bulletin.web.BulletinList;
import com.yedam.common.DBCommand;
import com.yedam.notice.web.NoticeList;

public class BulletinInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 입력값을 DB insert 후 -> 게시판 리스트로 이동 bulletinList.jsp
		String writer = request.getParameter("id");	// input 태그 hidden에 들어있는 값 세션정보 입력가능
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BulletinVO vo = new BulletinVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		
		BulletinService service = new BulletinServiceImpl();
		service.insertbulletin(vo);
		
		request.setAttribute("bulletin", vo);
		
		BulletinList commad = new BulletinList();
		commad.execute(request, response);
		
		return "/bulletinListPaging.do";
	}

}
