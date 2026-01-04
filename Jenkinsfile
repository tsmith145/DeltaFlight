pipeline {
    agent any

    stages {
        

        stage('Build & Run Cucumber Tests') {
			
            steps {
				
				dir ('C:/Users/Mjrlo/eclipse-workspace/cucumberProject'){
					
					 // For Maven projects:
                bat 'mvn clean test -Dcucumber.options="@login"' 
                // For Gradle projects:
                // sh './gradlew clean test -Dcucumber.filter.tags="@your_tag"'
                
                
				}
                
            }
        }

        stage('Publish Cucumber Reports') {
            steps {
                // Ensure the Cucumber reports plugin is installed in Jenkins
                //cucumber buildStatus: 'UNSTABLE', fileIncludePattern: '**/*.json'
                junit 'target/JSONReports/reports.html'
                cucumber buildStatus: 'UNCHANGED', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.html', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
            }
        }
    }
}