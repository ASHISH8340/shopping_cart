pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ASHISH8340/shopping_cart']])
                sh 'mvn clean install'
            }
        }
        // stage('build docker image'){
        //     steps{
        //         script{
        //             sh 'docker build -t ashish8972138/shopping_shop .'
        //         }
        //     }
        // }
//         stage('Push docker image to dockerhub'){
//             steps{
//                 script{
//                     withCredentials([string(credentialsId: 'dockerhubshop', variable: 'dockerhubshop')]) {
//                     sh 'docker login -u ashish8972138 -p ${dockerhubshop}'
// }
//                     sh 'docker push ashish8972138/shopping_shop'
//                 }
//             }
//         }
        
        stage('deploy with docker compose'){
            steps{
                script{
                    // def composeFile = 'docker-compose.yml'
                    sh 'docker-compose up -d'
                     
                    
                }
            }
        }
    }
    post {
        always{
            script{
                def composeFile = 'docker-compose.yml'
                 sh 'docker-compose -f ${composeFile} down'
            }
        }
    }
        
}