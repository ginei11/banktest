pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PagaTodo Test"
include(":app")


fun includePresentation(vararg featureName: String) {
    featureName.forEach {
        include(
            ":presentation:$it:api",
            ":presentation:$it:impl",
            ":presentation:$it:wiring"
        )
    }
}

fun includePresentationDesignSystem(vararg featureName: String) {
    featureName.forEach {
        include(
            ":presentation:$it",
            ":presentation:$it",
            ":presentation:$it"
        )
    }
}

fun includeCommons(vararg moduleName: String) {
    moduleName.forEach {
        include(":common:$it")
    }
}

fun includeDomains(vararg moduleName: String) {
    moduleName.forEach {
        include(":domains:$it:api", ":domains:$it:impl", ":domains:$it:wiring")
    }
}

includeDomains("banks")
includeCommons("navigation", "network")
includePresentation("navigation","features:banks")
includePresentationDesignSystem( "design-system:atoms", "design-system:organism")
