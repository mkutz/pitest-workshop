#!/usr/bin/env groovy
// see https://jenkins.io/doc/book/pipeline/syntax/

pipeline {

    agent any

    tools {
        maven "Maven 3.5.0"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: "50"))
    }

    stages {

        stage("Run Class Tests") {
            steps {
                dir("service/") {
                    ansiColor("xterm") { sh "mvn test pitest:mutationCoverage" }
                }
            }
            post {
                always {
                    junit "target/surefire-reports/TEST-*.xml"
                }
            }
        }

        stage("Update Sonar") {
            steps {
                dir("service/") {
                    ansiColor("xterm") { sh "mvn sonar:sonar" }
                }
            }
        }
    }

    post {
        always {
            deleteDir()
        }

        success {
            hipchatSend color: "GREEN", notify: true, room: "Team Fraggles Internal",
                message: "✓ <b>BUILT</b> <a href=\"${env.JOB_DISPLAY_URL}\">${env.JOB_NAME}</a> <b>v${env.VERSION}</b> " +
                        "<a href=\"${env.RUN_DISPLAY_URL}\">#${env.BUILD_NUMBER}</a> successful"
        }

        failure {
            hipchatSend color: "RED", notify: true, room: "Team Fraggles Internal",
                message: "⚡ <b>BUILT</b> <a href=\"${env.JOB_DISPLAY_URL}\">${env.JOB_NAME}</a> <b>v${env.VERSION}</b> " +
                        "<a href=\"${env.RUN_DISPLAY_URL}\">#${env.BUILD_NUMBER}</a> failed"
        }

        unstable {
            hipchatSend color: "YELLOW", notify: true, room: "Team Fraggles Internal",
                message: "✗ <b>BUILT</b> <a href=\"${env.JOB_DISPLAY_URL}\">${env.JOB_NAME}</a> <b>v${env.VERSION}</b> " +
                        "<a href=\"${env.RUN_DISPLAY_URL}\">#${env.BUILD_NUMBER}</a> has failing tests"
        }
    }
}
