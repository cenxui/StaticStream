/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 */

package file;

import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * 
 * @author cenxui
 * 2017/1/24
 * 
 * This class is used to modify the file permissions with specified 
 * operation system platform. For example, the Windows platform or
 * Unix platform.
 * 
 */

final class LinkFileAttribute {
	
	@SuppressWarnings("rawtypes")
	public static FileAttribute getPosixFileAttribute() {
		 Set<PosixFilePermission> perms =
			      PosixFilePermissions.fromString("r--r--r--");
		
		return	PosixFilePermissions.asFileAttribute(perms);
	}

}
