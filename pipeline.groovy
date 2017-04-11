node('docker maven:3.3.3') {
   stage('build') {
                sh 'mvn --version'
    }
}
