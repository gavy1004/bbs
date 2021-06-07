package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		return "main/main.tiles";
	}

}
