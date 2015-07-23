package io.github.amarcinkowski

import org.gradle.api.*;
import org.gradle.api.tasks.*;

class CleanEclipsePHPTask extends AbstractEclipsePHPTask {

	static final String SETTINGS_DIR = "/.settings";
	static final String BUILDPATH_FILE = "/.buildpath";
	static final String CLASSPATH_FILE = "/.classpath";

	@TaskAction
	def cleanEclipsePHP()  {
		def path = getProjectDir().getAbsolutePath()
		new File(path + SETTINGS_DIR).deleteDir()
		new File(path + BUILDPATH_FILE).delete()
		new File(path + CLASSPATH_FILE).delete()
	}
}
