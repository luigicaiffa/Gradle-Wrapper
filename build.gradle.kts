plugins {
    `java-library`
    jacoco
    `build-dashboard`
    id("com.gradle.build-scan") version "2.0.2"
}

repositories {
    mavenCentral()
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
}

dependencies {
    implementation("com.google.guava:guava:26.0-jre")
    testImplementation("junit:junit:4.12")
}

val jacocoTestReport by tasks.named("jacocoTestReport")
jacocoTestReport.dependsOn(tasks.named("test"))

val buildDashboard by tasks.named("buildDashboard")
buildDashboard.dependsOn(jacocoTestReport)
