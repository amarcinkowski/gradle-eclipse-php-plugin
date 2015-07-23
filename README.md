# gradle-eclipse-php-plugin
Gradle plugin for Eclipse PHP

This Gradle plugin allows you to generate project files for Eclipse PHP. Works similar to default 'eclipse' gradle plugin.
To use it add to your build.gradle.

## Configuration
Example code snippet that will make Eclipse PHP treat 'vendor', 'wp' and 'wp-content' folders as libraries:

```gradle
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.io.github.amarcinkowski:eclipse-php:1.2.5"
  }
}

apply plugin: "io.github.amarcinkowski.eclipse-php"

eclipsePHP {
  libraryFolders 'vendor', 'wp', 'wp-content'
}
```
Next add the project to your settings.gradle
```gradle
include 'myProjectName'
```

## Tasks
Now there are new gradle tasks available:
```
eclipsePHP
```
and
```
cleanEclipsePHP
```

* eclipsePHP creates Eclipse project with PHP nature (generates .project and .buildpath files and .settings folders with additional eclipse configurations)
* cleanEclipsePHP removes .project .buildpath .classpath and .settings from the project folder.
