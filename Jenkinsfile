pipeline {

    agent any
    tools {
        maven 'maven 3.9'
    }
    
    stages {
        stage("build jar") {
            steps {
               script {
                    echo "Building the JAR file..."
                    sh 'mvn package'
               }
            }
        }
    
    stages {
        stage("build image") {
            steps {
               script {
                    echo "Building docker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh 'docker build -t christianchika/my-demo-App:jma-2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push christianchika/my-demo-App:jma-2.0'
                            
                        
                    }
   
               }
            }
        }
      
        stage("Deploy") {
            steps {
                echo 'Deploying to Kubernetes cluster...'
                
            }
        }
    }
}
    post {
        always {
            echo 'This will always run after the pipeline completes.'
        }
        success {
            echo 'This will run only if the pipeline succeeds.'
        }
        failure {
            echo 'This will run only if the pipeline fails.'
        }
    }
}






// def gv
// pipeline {
//     agent any
//     parameters {
//         choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
//         booleanParam(name: 'executeTests', defaultValue: true, description: '')
//     }

//     stages {
//         stage("init") {
//             steps {
//                script {
//                    gv = load "script.groovy"
//                }
//             }
//         }

//     stage("Build") {
//             steps {
//                 script {
//                     gv.buildApp()
//                 }
//             }
//         }
//         stage("Test") {
//              when {
//                 expression { return params.executeTests }
//             }
//             steps {
//                 script {
//                     gv.testApp()
//                 }
//             }
//         }
//         stage("Deploy") {
//             steps {
//                 script {
//                  env.ENV = input message: 'Select environment to deploy:', ok: 'Deploy', parameters: [choice(name: 'ENV', choices: ['development', 'staging', 'production'], description: '')]
//                     gv.deployApp()
//                     echo "Deploying to ${ENV}"
//             }
//         }
//     }
// }
//     post {
//         always {
//             echo 'This will always run after the pipeline completes.'
//         }
//         success {
//             echo 'This will run only if the pipeline succeeds.'
//         }
//         failure {
//             echo 'This will run only if the pipeline fails.'
//         }
//     }
// }
