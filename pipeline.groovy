node('master') {
   //docker maven:3.3.3
   stage('build') {
      withMaven(maven:'maven339')
      //def mvnTool = tool 'Maven_3_3_3'

      //sh "${mvnTool}/bin/mvn --version"
       sh "mvn --version"
    }
}
