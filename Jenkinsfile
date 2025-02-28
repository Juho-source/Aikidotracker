pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Juho-source/Aikidotracker.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
