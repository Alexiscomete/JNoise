group = "de.articdive"
version = "1.0.0"

plugins {
    java
    id("maven-publish")
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    // Jetbrains annotations
    compileOnly("org.jetbrains:annotations:19.0.0")
    // JUnit testing framework
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "de.articdive"
            artifactId = "jnoise"
            version = "${project.version}"

            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "Articdive-Nexus-OSS-3-Repository"
            url = uri("https://repo.articdive.de/repository/maven-releases")
            credentials {
                username="${project.properties["repository_username"]}"
                password="${project.properties["repository_password"]}"
            }
        }
    }
}