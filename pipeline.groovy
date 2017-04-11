node('master') {
   //docker maven:3.3.3
   stage('build') {
                sh 'mvn --version'
                sh 'ls'
    }
}
