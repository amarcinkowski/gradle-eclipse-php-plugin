package io.github.amarcinkowski

import org.gradle.api.*;
import org.gradle.api.tasks.*;

class CleanEclipsePHPTask extends AbstractEclipsePHPTask {
  
  @TaskAction
  def cleanEclipsePHP()  {
	def path = getProjectDir().getAbsolutePath()
	new File(path + "/.settings").deleteDir()
	new File(path + "/.buildpath").delete()
	new File(path + "/.classpath").delete()
  }
}
