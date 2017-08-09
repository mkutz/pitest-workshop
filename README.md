Pitest Workshop
===============

[![Build Status](https://travis-ci.org/mkutz/pitest-workshop.svg?branch=master)](https://travis-ci.org/mkutz/pitest-workshop)

Workshop for mutation testing with [Pitest]. In this project I use [Groovy] and [Spock] for testing simply because I like it better than [JUnit]. However [Pitest] works just fine for [Junit] as well. 

Project Setup with Maven
------------------------
In order to use Pitest into our Maven project we just need to add the plugin ito our [pom.xml](pom.xml) like [this](pom.xml#L97-L113).

Note that [the `timestampedReports` configuration](pom.xml#L102) will cause [Pitest] to not put its reports into timestamped directories but overwrite old reports. This makes it easier to find the report after running the analysis.

Also note that [the `execution` configuration](pom.xml#L105-L112) will cause [Pitest] to run every time you run `mvn install` or `verify`. Since mutation testing takes a lot of time you might want to move this into a profile or just run `mvn install pitest:mutationCoverage` manually.

Sonar Integration
-----------------
In order to get the mutation test coverage information into your Sonar:

1. Install local [SonarQube] for testing.
   I personally use [Docker] for that, simply running
   ```docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube```
   If everything worked, you should see a SonarQube [here](http://localhost:9000).
2. Run
   ```mvn install sonar:sonar```
   to create the project. If that worked, you should find your analysis [here](http://localhost:9000/dashboard?id=de.assertagile.workshop%3Apitest-workshop).
   You won't find any mutation data for now, since we are missing required plugins.
3. Install plugins for Groovy and Pitest:
   1. [Login](http://localhost:9000/sessions/new) to your local SonarQube (user name and password should be both "admin").
   2. Go to [Update Center](http://localhost:9000/updatecenter/available) and find "Groovy" and "Pitest" and click the "Install" button.
   3. Scroll up and click "Restart" button to finish the installation.
4. Make sure you have [the `sonar.pitest.mode` property](pom.xml#L22) set, otherwise [SonarQube] plugin will simply ignore the mutation coverage data.
5. When you now run
   ```mvn install sonar:sonar```
   you will find a new kind of [measure](http://localhost:9000/component_measures?id=de.assertagile.workshop%3Apitest-workshop) named [mutation analysis](http://localhost:9000/component_measures/domain/Mutation%20analysis?id=de.assertagile.workshop%3Apitest-workshop)
6. Optionally active the additional [coding rules](http://localhost:9000/coding_rules#repositories=pitest)

Objectives
----------
- [ ] Checkout [User] and [UserClassSpec].
- [ ] Run Pitest via `mvn install pitest:mutationCoverage`, open the [report] and try to understand it.
- [ ] Run Sonar analysis via `mvn sonar:sonar` and check the mutation analysis in [SonarQube].
- [ ] Try to "kill" the remaining mutations one by one.


[Pitest]: <http://pitest.org>
[Groovy]: <http://www.groovy-lang.org/>
[Spock]: <https://github.com/spockframework/spock>
[JUnit]: <http://junit.org>
[SonarQube]: <https://www.sonarqube.org/>
[Docker]: <https://www.docker.com/>

[User]: <src/main/java/de/assertagile/workshop/pitest/User.java>
[UserClassSpec]: <src/test/groovy/de/assertagile/workshop/pitest/UserClassSpec.groovy>
[report]: <target/pit-reports/de.assertagile.workshop.pitest/index.html>
