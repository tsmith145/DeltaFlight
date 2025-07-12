pipeline {
    agent any

    stages {
        

        stage('Build & Run Cucumber Tests') {
			
            steps {
				
				dir ('DeltaFlight'){
					
					 // For Maven projects:
                sh 'mvn clean test -Dcucumber.optioms="@login"' 
                // For Gradle projects:
                // sh './gradlew clean test -Dcucumber.filter.tags="@your_tag"'
                
                
				}
                
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