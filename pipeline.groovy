node {
}
node('master') {
   //docker maven:3.3.3
   stage('build') {
      def mvnTool = tool 'Maven_3_3_9'

      sh "${mvnTool}/bin/mvn--version"
    }
}
