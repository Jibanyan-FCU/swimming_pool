pipeline {
    agent any
    /* insert Declarative Pipeline here */
    stages {
        stage('run-test') {
            /* when {
                anyOf {
                    branch 'master'
                    branch 'dev'
            	   }
            } */
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
                jacoco(
                    classPattern: 'app/build/classes',
                    inclusionPattern: '**/*.class',
                    exclusionPattern: '**/*Test*.class',
                    execPattern: 'app/build/jacoco/**/*.exec'
            	   )
            }
        }
        stage('sinarqube-analysis'){
            enviroment {
                SONAR_TOKEN = credentials('4723fa8aca804e9e9b07b74457b80869a33612c2')
            }
            steps {
                sh '''./gradlew sonarqube \
                    -Dsonar.projectKey=swimming-pool-d0745587 \
                    -Dsonar.host.url=http://140.134.26.54:10990 \
                    -Dsonar.login=SONAR_TOKEN
                '''
            }
        }
    }
}
