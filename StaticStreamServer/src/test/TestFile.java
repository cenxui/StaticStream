package test;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class TestFile {

	public static void main(String[] args) {
		listFiles();
		
	}

	private static void listFiles() {
		Path path = Paths.get("/usr/local/Cellar/nginx/1.10.2_1/html/video");
		
		try {
			Files.list(path).forEach((p) -> {
				try {
					Files.createSymbolicLink(Paths.get("/usr/local/Cellar/nginx/1.10.2_1/html/"+ "hello123" + ".mp4" ), p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
