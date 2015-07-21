package io.github.amarcinkowski

import org.gradle.api.*;

class EclipsePHPPlugin implements Plugin<Project> {
  static final String PHP_CONFIGURATION_NAME = 'php'
  
  @Override
  void apply(Project project) {
	project.plugins.apply('eclipse')
	project.plugins.apply('eclipse-wtp')
	project.extensions.create("libraryFolders", EclipsePHPPluginExtension)
	configureTask(project)
	project.task('eclipsePHP', type: EclipsePHPTask).dependsOn('eclipse')
	project.task('cleanEclipsePHP', type: CleanEclipsePHPTask).dependsOn('cleanEclipse')
//	project.getExtensions().getByName('eclipse').getProject().setNatures(['org.eclipse.php.core.PHPNature'])
//	println project.getExtensions().getByName('eclipse').getWtp().getFacet().getProperties()
  }
  
  private void configureTask(Project project) {
	project.tasks.withType(AbstractEclipsePHPTask) {
		conventionMapping.map('projectDir') { project.projectDir }
		conventionMapping.map('libraryFolders') { project.eclipsePHP.libraryFolders }
	}
  }
}