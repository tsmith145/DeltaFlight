pipeline {
    agent any

    stages {
        

        stage('Build & Run Cucumber Tests') {
			
            steps {
				
				dir ('C:/Users/Mjrlo/eclipse-workspace/cucumberProject/'){
					
					 // For Maven projects:
                bat 'mvn clean test -Dtest=TestRunner.java' 
                // For Gradle projects:
                // sh './gradlew clean test -Dcucumber.filter.tags="@your_tag"'
                
                
				}
                
            }
        }

        stage('Publish Cucumber Reports') {
            steps {
				
			publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, icon: '', keepAll: false, reportDir: 'C:\\Users\\Mjrlo\\eclipse-workspace\\cucumberProject\\target\\surefire-reports\\Surefire suite', reportFiles: 'Surefire test.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
        
        post {
        always {
            emailext (
                subject: "${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: '${FILE, path="C:\\Users\\Mjrlo\\eclipse-workspace\\cucumberProject\\target\\surefire-reports\\Surefire suite\\Surefire test.html"}', // Embeds HTML file content
                to: 'timothesmith0320@gmail.com',
                mimeType: 'text/html'
            )
        }
    }
    }
}