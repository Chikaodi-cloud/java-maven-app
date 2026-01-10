def gv
pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    stages {
        stage("init") {
            steps {
               script {
                   gv = load "script.groovy"
               }
            }
        }

    stage("Build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("Test") {
             when {
                expression { return params.executeTests }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("Deploy") {
            input {
                message "Select the environment to deploy to"
                ok "Done"
                parameters {
                    choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: '')
                    
            steps {
                script {
                    gv.deployApp()
                    echo "Deploy to ${ENV}"
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


// pipeline {
//     agent any
//     parameters {
//         choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
//         booleanParam(name: 'executeTests', defaultValue: true, description: '')
//     }

//     stages {
//         stage('Build') {
//             steps {
//                 echo 'Building...'
//                 // Add build steps here
//             }
//         }
//         stage('Test') {
//              when {
//                 expression { return params.executeTests }
//             }
//             steps {
//                 echo 'Testing...'
//                 // Add test steps here
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 echo 'Deploying...'
//                 echo "Deploying version: ${params.VERSION}"
//                 // Add deploy steps here
//             }
//         }
//     }

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
