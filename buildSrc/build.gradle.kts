import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
   maven("https://ci-repo.aexp.com/java-proxy/content/repositories/iq-maven-central-proxy/")
   mavenCentral()
}

plugins {
   `kotlin-dsl`
}
