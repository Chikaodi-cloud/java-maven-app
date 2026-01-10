def buildJar() {
    echo "Building the JAR file..."
    sh 'mvn clean package'
    // Add build logic here
}
def buildImage() {
    echo "Building docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerHub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
      sh 'docker build -t christianchika/my-demo-app:jma-2.0 .'
      sh 'echo $PASS | docker login -u $USER --password-stdin'
      sh 'docker push christianchika/my-demo-app:jma-2.0'
    // Add build logic here
}
}
def deployApp() {
    echo 'Deploying the application...'
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
