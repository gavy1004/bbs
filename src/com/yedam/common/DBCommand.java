package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DBCommand {
	
    public String execute(HttpServletRequest request, HttpServletResponse response);

}
