pipeline {
  agent any
  stages {
    stage('Testing') {
      steps {
        git(url: 'https://github.com/YoungPhoenix09/simple-image-server', credentialsId: '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')
        withGradle() {
          sh './gradlew build'
        }

        catchError(catchInterruptions: true, message: 'One of more tests have failed')
      }
    }

  }
}