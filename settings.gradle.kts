
pluginManagement {

    repositories {
        maven {
            url = uri("https://repo.bankino.io/repository/maven-plugins/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/gradle-plugins/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/google-dl/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/jcenter/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/jitpack/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/maven-central/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/maven-public/")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        maven {
            url = uri("https://repo.bankino.io/repository/maven-plugins/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/gradle-plugins/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/google-dl/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/jcenter/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/jitpack/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/maven-central/")
        }
        maven {
            url = uri("https://repo.bankino.io/repository/maven-public/")
        }

    }
}
rootProject.name = ("Persian_Dictionary")
include (":app")
