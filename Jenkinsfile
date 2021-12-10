pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean compile"
            }
        }
       

        stage('deploy') { 
            steps {
                sh "mvn package"
            }
        }


        stage('Build Docker image'){
            steps {
              
                sh 'docker build -t  dvazhavalnt/helloworld:latest .'
            }
        }

        stage('Docker Login'){
            
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u dvazhavalnt -p ${divya2521997}"
                }
            }                
        }

        stage('Docker Push'){
            steps {
                sh 'docker push dvazhavalnt/helloworld:latest'
            }
        }
        
        stage('Docker deploy'){
            steps {
               
                sh 'docker run -itd -p  8081:8080 dvazhavalnt/helloworld:latest'
            }
        }

        
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}

