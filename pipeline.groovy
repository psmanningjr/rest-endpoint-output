node('maven') {
   //docker maven:3.3.3
   withMaven(maven:'Maven_3_0_5')
   stage('build') {
      //def mvnTool = tool 'Maven_3_3_3'

      //sh "${mvnTool}/bin/mvn --version"
       sh "mvn --version"
    }
}
