package io.github.amarcinkowski

import org.gradle.api.*;
import org.gradle.api.tasks.*;

class EclipsePHPTask extends AbstractEclipsePHPTask {

	def eclipseChecksum(String dir) {
		def checksum = dir.length() < 10 ? String.format('%02d',dir.length()) : String.format('1%02d',dir.length())
		checksum
	}

	@TaskAction
	def eclipsePHP() {
		def path = getProjectDir().getAbsolutePath()
		File f = new File( path + "/.settings/org.eclipse.wst.validation.prefs")
		def folders = "disabled="
		getLibraryFolders().each {
			folders += eclipseChecksum(it.toString()) + it
		}
		f.write(folders + System.getProperty("line.separator"))
		f.append('eclipse.preferences.version=1' + System.getProperty("line.separator"))
	}
}
	