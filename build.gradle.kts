plugins {
    id("io.freefair.lombok") version "6.3.0" apply false
}

subprojects {
    apply<JavaPlugin>()
    apply(plugin = "io.freefair.lombok")

    tasks {
        named<Test>("test") {
            useJUnitPlatform()
        }
    }

    dependencies {
        add("implementation", "org.apache.commons:commons-lang3:3.12.0")
        add("implementation", "org.slf4j:slf4j-api:1.7.32")
        add("implementation", "ch.qos.logback:logback-classic:1.2.6")
        add("testImplementation", platform("org.junit:junit-bom:5.8.1"))
        add("testImplementation", "org.junit.jupiter:junit-jupiter")
        add("testImplementation", "org.junit.jupiter:junit-jupiter-params")
        add("testImplementation", "org.junit-pioneer:junit-pioneer:1.5.0")
        add("testImplementation", "org.assertj:assertj-core:3.22.0")
    }

    repositories {
        mavenCentral()
    }
}

