// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.ClasspathDependencies.gradlePlugin)
        classpath(Dependencies.ClasspathDependencies.kotlin)
        classpath(Dependencies.ClasspathDependencies.hilt)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}