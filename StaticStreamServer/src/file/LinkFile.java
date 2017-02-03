/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 */

package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import config.AppConfig;


/**
 * This class is used to save the meta data of a symbolic link file. The meta
 * data includes the expired timed and URL of a symbolic link.
 * 
 * @author cenxui 2017/1/23
 */

@ThreadSafe
final class LinkFile {
	private final Path path;

	private final long expiredTime;

	/**
	 * 
	 * @param symbolicLinkURL
	 */

	public LinkFile(String symbolicLinkURL) {
		path = Paths.get(symbolicLinkURL);
		expiredTime = System.currentTimeMillis() + AppConfig.EXPAIRED_TIME;
	}

	/**
	 * This method is used to get the expired time of this link.
	 * 
	 * @return the expired time of this symbolic link
	 */

	public long getExpirdTime() {
		return expiredTime;
	}

	/**
	 * This method is used to remove a symbolic link related to this instance.
	 * 
	 * @throws IOException
	 *             throws exceptions if this symbolic file dose not exit.
	 */

	public void deletFilesLink() throws IOException {
		Files.delete(path);
	}

	public String getFileName() {
		return path.getFileName().toString();
	}
}
