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
//             input {
//                 message "Select the environment to deploy to"
//                 ok "Done"
//                 parameters {
//                     choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], description: '')
//                     choice(name: 'TWO', choices: ['dev', 'staging', 'prod'], description: '')
//                 }
//             }
                    
//             steps {
//                 script {
//                     gv.deployApp()
//                     echo "Deploying to ${ONE}"
//                     echo "Deploying to ${TWO}"
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
            steps {
                script {
                 env.ENV = input message: 'Select environment to deploy:', ok: 'Deploy', parameters: [choice(name: 'ENV', choices: ['development', 'staging', 'production'], description: '')]
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
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
