pipeline {
  agent any
  stages {
    stage('Testing') {
      steps {
        sh '''pwd
ls'''
        withGradle() {
          sh 'gradle wrapper'
          sh './gradlew build'
          sh 'ls'
        }

      }
    }

  }
}