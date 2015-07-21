package io.github.amarcinkowski

import org.gradle.api.*;
import org.gradle.api.tasks.*;


class AbstractEclipsePHPTask extends DefaultTask {
	@Input
	File projectDir
	@Input
	@Optional
	String[] libraryFolders
}
