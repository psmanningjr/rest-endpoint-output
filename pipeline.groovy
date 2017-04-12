node('maven') {
   //docker maven:3.3.3
   String pomFileLocation = env.BUILD_CONTEXT_DIR ? "${env.BUILD_CONTEXT_DIR}/pom.xml" : "pom.xml"


   stage('build') {
      //withMaven(maven:'maven339')
      //def mvnTool = tool 'Maven_3_3_3'

      //sh "${mvnTool}/bin/mvn --version"
      sh "ls -tal"
      sh "mvn clean install -f ${pomFileLocation} "
      //sh "mvn --version"
    }
}
