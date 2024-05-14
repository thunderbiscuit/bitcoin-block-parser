plugins {
    alias(libs.plugins.jvm)
    `java-library`
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("me.tb:bitcoin-tx-parser:0.1.1-SNAPSHOT")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use Kotlin Test test framework
            useKotlinTest("1.9.20")
        }
    }
}

kotlin {
    explicitApi()

    compilerOptions {
        freeCompilerArgs = listOf(
            "-opt-in=kotlin.ExperimentalUnsignedTypes",
            "-opt-in=kotlin.ExperimentalStdlibApi",
        )
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
