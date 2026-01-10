def buildApp() {
    echo "Building the application..."
    // Add build logic here
}
def testApp() {
    echo "Testing the application..."
    // Add test logic here
}
def deployApp() {
    echo 'Deploying the application...'
    echo "Deploying version: ${params.VERSION}"
    // Add deploy logic here
}

return this




// def buildJar() {
//     echo "building the application..."
//     sh 'mvn package'
// } 

// def buildImage() {
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t nanajanashia/demo-app:jma-2.0 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push nanajanashia/demo-app:jma-2.0'
//     }
// } 

// def deployApp() {
//     echo 'deploying the application...'
// } 

// return this
