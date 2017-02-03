/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 * 
 * 
 * 
 */
package file;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author cenxui
 * 2017/1/23
 */

public final class LinkFileManager {
	
	private static final LinkFileManager instance = new LinkFileManager();
	
	private boolean isRunning = false;
	
	private boolean isStarted = false;
	
	private Thread thread;
	
	private final LinkFileQueue queue = LinkFileQueue.getInstance();
	
	private Logger logger = Logger.getLogger(Class.class.getName());
	
	
	public static LinkFileManager getManager() {
		return instance;
	}

	public void start() {
		
		logger.log(Level.INFO, "LinkFileManager started");
		
		if (isStarted == true) {
			throw new RuntimeException("LinkFileManager was started and it can not start again");
		}
		
		isStarted = true;
		
		isRunning = true;
		
		thread = new Thread(		
				() -> { 
					logger.log(Level.INFO, "LinkFileManager is running");
					while (isRunning) {
						manageLinkFile();
					}	
					logger.log(Level.INFO, "LinkFileManager stoped");
				});
		
		thread.start();
			
	}

	private void manageLinkFile() {
		long currentTimeMillis = System.currentTimeMillis();
		
		while (isRunning) {
			if (queue.peek() == null) {
				continue;
			}
			
			if (queue.peek().getExpirdTime() > currentTimeMillis) {
				break;
			}
			
			deleteLinkFile();
		}
	}

	private void deleteLinkFile() {
		try {
			LinkFile linkFile = queue.poll();
			linkFile.deletFilesLink();
			logger.log(Level.INFO, "deleteLinkFile : " + linkFile.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		isRunning = false;
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public boolean isStarted() {
		return isStarted;
	}
}
