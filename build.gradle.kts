plugins {
    kotlin("multiplatform") version "1.5.20"
}

group = "com.ivanhai"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation("org.testng:testng:7.1.0")
                implementation("org.junit.jupiter:junit-jupiter:5.7.0")
            }
        }
    }
}
