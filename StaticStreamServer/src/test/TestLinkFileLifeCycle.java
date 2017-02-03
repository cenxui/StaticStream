package test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import config.AppConfig;
import file.LinkFileCreator;
import file.LinkFileManager;

public class TestLinkFileLifeCycle {
	
	private String fileName = "avtest.mp4";
	
	@Before
	public void setUp() {
		LinkFileManager manager = LinkFileManager.getManager();
		manager.start();
		
	}

	@Test
	public void test() {
		for (;;) {
			try {
				LinkFileCreator.createLinkFile(AppConfig.FILE_FOLDER, fileName, AppConfig.LINK_FOLDER);
				
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
