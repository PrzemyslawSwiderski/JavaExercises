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
        add("implementation", "org.slf4j:slf4j-api:1.7.32")
        add("implementation", "ch.qos.logback:logback-classic:1.2.6")
        add("testImplementation", platform("org.junit:junit-bom:5.8.1"))
        add("testImplementation", "org.junit.jupiter:junit-jupiter")
    }

    repositories {
        mavenCentral()
    }
}

