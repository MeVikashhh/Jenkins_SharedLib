def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  // sh "sudo usermod -aG docker $USER"
  // sh "newgrp docker"
  sh "sudo docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
