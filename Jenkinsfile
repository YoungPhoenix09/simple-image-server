pipeline {
  agent any
  stages {
    stage('Testing') {
      steps {
        sh '''pwd
ls'''
        withGradle() {
          sh './gradlew build'
          sh 'ls'
        }

      }
    }

  }
}