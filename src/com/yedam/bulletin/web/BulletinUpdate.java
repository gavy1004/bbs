package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DBCommand;

public class BulletinUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
				
				if(request.getMethod().equals("POST")) {
					
					String id = request.getParameter("num");
					String title = request.getParameter("title");
					String content = request.getParameter("content");
					
					BulletinVO vo = new BulletinVO();
					vo.setId(Integer.parseInt(id));
					vo.setTitle(title);
					vo.setContent(content);
					
					BulletinService service = new BulletinServiceImpl();
					service.updatebulletin(vo);
					
					request.setAttribute("bulletin", vo);
					
					BulletinList commad = new BulletinList();
					commad.execute(request, response);
					
					return "bulletin/bulletinList.tiles";
				}else {
					String id = request.getParameter("id");
					System.out.println(id);
					
					BulletinVO vo = new BulletinVO();
					vo.setId(Integer.parseInt(id));
					
					BulletinService service = new BulletinServiceImpl();
					service.deletebulletin(vo);
					
					BulletinList commad = new BulletinList();
					commad.execute(request, response);
					
					return "/bulletinListPaging.do";
				}
	
	}
}
