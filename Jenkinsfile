pipeline {
    agent any 
        tools{
            maven 'Maven-3.9.3'
        }
        environment {   
        DOCKER_REGISTRY = "https://index.docker.io/v1/"
        DOCKER_IMAGE_NAME = "dayalathakodagi/jenkins-devops:latest"
    }
        stages{
            stage('Build Maven'){
                steps{
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/dmnglor/devops-automation']])
                    bat 'mvn clean install'
                }
            }
            stage('Docker Image to Docker Hub'){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'DOCKER_HUB_CREDENTIALS_PSW', usernameVariable: 'DOCKER_HUB_CREDENTIALS_USR')]) {
                        
                        bat "docker build -t ${DOCKER_IMAGE_NAME} ."
                        bat "docker login -u ${DOCKER_HUB_CREDENTIALS_USR} -p ${DOCKER_HUB_CREDENTIALS_PSW} ${DOCKER_REGISTRY}"

                        // Push the Docker image to your container registry
                        bat "docker push ${DOCKER_IMAGE_NAME}"
                }
            }
        }
        }
                
            }
        }
        
        
