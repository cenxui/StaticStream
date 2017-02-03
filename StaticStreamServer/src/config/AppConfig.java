/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 */

package config;

/**
 * 
 * @author cenxui
 * 2017/1/23
 * The main configuration about the file source and 
 * life cycle of file links. 
 */

public class AppConfig {
	
	/**
	 * EXPAIRED_TIME is used to determine the life cycle of a file link in milliseconds.
	 */
	public static final long EXPAIRED_TIME = 10000;
	
	/**
	 *  FILE_FOLDER is used to get the link of the video source folder.
	 */	
	public static String FILE_FOLDER = "/usr/local/Cellar/nginx/1.10.2_1/html/video";
	
	/**
	 * LINK_FOLDER is used to specify the file links should be stored.
	 */
	public static String LINK_FOLDER = "/usr/local/Cellar/nginx/1.10.2_1/html";
	
	/**
	 * SUFFIX is used to specify the file format.
	 */
	public static String SUFFIX = ".mp4";
	
	/**
	 * ERROR_URL is used as a redirect link when error happens.
	 */
	public static String ERROR_URL = "https://www.google.com.tw";
	
}
