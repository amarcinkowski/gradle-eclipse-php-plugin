# gradle-eclipse-php-plugin
Gradle plugin for Eclipse PHP

This Gradle plugin allows you to generate project files for Eclipse PHP. Works similar to default 'eclipse' gradle plugin.
To use it add this code snippet to your build.gradle:

```
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
```

Available task are:
```
eclipsePHP
```
and
```
cleanEclipsePHP
```
