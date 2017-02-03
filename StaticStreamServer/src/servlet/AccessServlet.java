/*
 * 
/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 */

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.AppConfig;
import file.LinkFileCreator;
import file.LinkFileManager;

/**
 * Servlet implementation class AccessServlet
 * @author cenxui 
 * 2017/2/2
 */
@WebServlet("/AccessServlet")
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 120539194805163L;
       
	static {
		LinkFileManager.getManager().start();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	String query = request.getQueryString();
		
		String path = LinkFileCreator.createLinkFile(AppConfig.FILE_FOLDER, "avtest.mp4", AppConfig.LINK_FOLDER);
		
		String localhost = request.getLocalAddr();
		
		response.sendRedirect("http://" + localhost + "/" + path);
		
	}
	
}
