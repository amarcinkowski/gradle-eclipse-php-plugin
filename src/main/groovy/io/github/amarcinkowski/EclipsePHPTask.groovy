package io.github.amarcinkowski

import org.gradle.api.*;
import org.gradle.api.tasks.*;

class EclipsePHPTask extends AbstractEclipsePHPTask {

	final static String ECLIPSE_VALIDATION_PREFS_DIR =  "/.settings";
	final static String ECLIPSE_VALIDATION_PREFS_FILE =  "/org.eclipse.wst.validation.prefs";
	final static String DISABLED = "disabled=";

	def eclipseChecksum(String dir) {
		def checksum = dir.length() < 10 ? String.format('%02d',dir.length()) : String.format('1%02d',dir.length())
		checksum
	}

	/**
	 * main task that generates validation preferences for Eclipse PHP
	 */
	@TaskAction
	def eclipsePHP() {
		def path = getProjectDir().getAbsolutePath()
		File folder = new File(path + ECLIPSE_VALIDATION_PREFS_DIR)
		if (!folder.exists()) {
			folder.mkdirs()
		}
		File f = new File(path + ECLIPSE_VALIDATION_PREFS_DIR + ECLIPSE_VALIDATION_PREFS_FILE)
		def folders = DISABLED;
		getLibraryFolders().each {
			folders += eclipseChecksum(it.toString()) + it
		}
		f.write(folders + System.getProperty("line.separator"))
		f.append('eclipse.preferences.version=1' + System.getProperty("line.separator"))
	}
}
