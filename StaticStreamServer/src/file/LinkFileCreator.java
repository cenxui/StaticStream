/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 */

package file;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.LinkPermission;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import config.AppConfig;

/**
 * 
 * @author cenxui
 * 2017/2/2
 */

public final class LinkFileCreator {
	
	/**
	 * 
	 * @param fileFolder 
	 * @param fileName
	 * @param symbolicLinkFolder
	 * @return 
	 * @throws  IOException
     *          if an I/O error occurs
     * @throws  SecurityException
     *          In the case of the default provider, and a security manager
     *          is installed, it denies {@link LinkPermission}<tt>("symbolic")</tt>
     *          or its {@link SecurityManager#checkWrite(String) checkWrite}
     *          method denies write access to the path of the symbolic link.
     */

	public static String createLinkFile(String fileFolder, String fileName, String symbolicLinkFolder) throws IOException {
		if (fileName == null || fileName.length() == 0) {
			throw new RuntimeException("fileName can not be null or empty");
		}
		
		if (fileFolder == null || fileFolder.length() == 0) {
			throw new RuntimeException("fileFolder can not be null or empty");
		}
		

		if (symbolicLinkFolder == null || symbolicLinkFolder.length() == 0) {
			throw new RuntimeException("symbolicLinkFolder can not be null or empty");
		}
			
		Path filePath = Paths.get(fileFolder, fileName);
				
		String symbolicLinkFileName = BigInteger.probablePrime(64, new SecureRandom()).toString();
		
		Path sybolicPath = Paths.get(symbolicLinkFolder, symbolicLinkFileName + AppConfig.SUFFIX);
		
//		Files.createSymbolicLink(sybolicPath, filePath, LinkFileAttribute.getPosixFileAttribute());
		
		Files.createSymbolicLink(sybolicPath, filePath);
		
		LinkFileQueue.getInstance().offer(new LinkFile(sybolicPath.toString()));

		return symbolicLinkFileName + AppConfig.SUFFIX;
	}
}
