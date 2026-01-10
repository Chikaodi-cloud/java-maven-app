// #!/usr/bin/env groovy
// pipeline {
//     agent any
//     stages {
//         stage("test"){
//             steps {
//                 script {
//                     echo "Testing the application..."
//                     echo "Excuting pipeline for branch $BRANCH_NAME"
//                 }
//             }
//         }
//         stage('build') {
//             when {
//                 expression{
//                     BRANCH_NAME == 'main'
//                 }
//             }
//             steps {
//                 script {
//                     echo "Building the application.."
//                 }
//             }
//         }
//         stage('deploy') {
//             when {
//                 expression{
//                     BRANCH_NAME == 'main'
//                 }
//             }
//             steps {
//                 script {
//                     echo "Deploying the application..."
//                 }
//             }
//         }
//     }
// }


pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Add build steps here
            }
        }
        stage('Test') {
             when {
                expression { return params.executeTests }
            }
            steps {
                echo 'Testing...'
                // Add test steps here
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                echo "Deploying version: ${params.VERSION}"
                // Add deploy steps here
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
