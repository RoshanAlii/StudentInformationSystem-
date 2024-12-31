pipeline {
    agent any

    environment {
        // Replace with your Docker Hub credentials and repo name
        DOCKER_HUB_CREDENTIALS = 'docker-hub-credentials-id'
        DOCKER_HUB_REPO = 'yourdockerhubuser/studentinfosystem'
        VERSION_TAG = '1.0'
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/YourGitHubUsername/StudentInfoSystem.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_HUB_REPO}:${VERSION_TAG} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: "${DOCKER_HUB_CREDENTIALS}",
                              usernameVariable: 'DOCKER_USER',
                              passwordVariable: 'DOCKER_PASS')]) {
                        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                        sh "docker push ${DOCKER_HUB_REPO}:${VERSION_TAG}"
                    }
                }
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }
    }
}
