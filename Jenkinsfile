pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    echo 'Testing the application...'
                    echo "Executing application for ${env.BRANCH_NAME}"
                    // Add checkout steps here
                }
            }
        }

        stage('Build') {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'staging'
                }
            }
            steps {
                script {
                    echo 'Building the application...'
                    // Add build steps here
                }
            }
        }

        stage('Deploy') {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'staging'
                }
            }
            steps {
                script {
                    echo 'Deploying the application...'
                    // Add deploy steps here
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
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
