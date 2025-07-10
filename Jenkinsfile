pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // Replace with your SCM details (e.g., Git, SVN)
                git 'https://github.com/your-repo/your-cucumber-project.git'
            }
        }

        stage('Build & Run Cucumber Tests') {
            steps {
                // For Maven projects:
                sh 'mvn clean test -Dcucumber.optioms="@login"' 
                // For Gradle projects:
                // sh './gradlew clean test -Dcucumber.filter.tags="@your_tag"' 
            }
        }

        stage('Publish Cucumber Reports') {
            steps {
                // Ensure the Cucumber reports plugin is installed in Jenkins
                cucumber buildStatus: 'UNSTABLE', fileIncludePattern: '**/*.json'
            }
        }
    }
}