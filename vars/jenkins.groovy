#!/bin/vars/groovy
import hudson.model.*
import Json
import SonarQube
import Git

def response

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        //def datas
        agent { node { label 'agent-1' } }

        environment {
            TEST = "tasks-app"
        }

        stages {
            stage('Validation') {
                steps {
                    checkout scm
                    script {
                        echo NODE_NAME
                        Json json = new Json (this)
                        def Message = json.doprintJson()
                        println(Message)
                    }
                }
            }
            stage('Yml') {
                steps {
                    checkout scm
                    script {
                        //sh "ls -la"
                        sh 'printenv'
                        Yml yml = new Yml (this)
                        def ymlFile = yml.readFileYml("version")
                        println(ymlFile)
                    }
                }
            }
            stage('SonarQube') {
                steps {
                    script {
                        SonarQube sonarQube = new SonarQube(this)
                        sonarQube.doAnalyzing()
                    }
                }
            }
            stage('MyError') {
                steps {
                    script {
                        sh "echo success"
                    }
                }
            }
        }
    }
}
