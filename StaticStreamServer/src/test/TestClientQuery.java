package test;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestClientQuery {
	public static void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("\n getAuthType : " + request.getAuthType());
		response.getWriter().write("\n getRemoteAddr : " + request.getRemoteAddr());
		response.getWriter().write("\n getQueryString : " + request.getQueryString());
		response.getWriter().write("\n getCharacterEncoding : " + request.getCharacterEncoding());
		response.getWriter().write("\n getContextPath : " + request.getContextPath());		
		response.getWriter().write("\n getLocalAddr : " + request.getLocalAddr());
		response.getWriter().write("\n getMethod : " + request.getMethod());
		response.getWriter().write("\n getRequestURI : " + request.getRequestURI());
		response.getWriter().write("\n getRequestURL : " + request.getRequestURL());
	}
}
