node('master') {
   sh "ls -tal"
   sh "ls -tal /tmp"
}

node('maven') {
   stage('SCM Checkout') {

    checkout scm

   }
   
   //docker maven:3.3.3
   String pomFileLocation = env.BUILD_CONTEXT_DIR ? "${env.BUILD_CONTEXT_DIR}/pom.xml" : "pom.xml"


   stage('build') {
      //withMaven(maven:'maven339')
      //def mvnTool = tool 'Maven_3_3_3'

      //sh "${mvnTool}/bin/mvn --version"
      sh "ls -tal /tmp/workspace/anothertst"
      sh "mvn clean install -f ${pomFileLocation} "
      //sh "mvn --version"
    }
}
