Pitest Workshop
===============

Workshop for mutation testing with [Pitest]. In this project I use [Groovy] and [Spock] for testing simply because I like it better than [JUnit]. However [Pitest] works just fine for [Junit] as well. 

Project Setup with Maven
------------------------
In order to use Pitest into our Maven project we just need to add the plugin ito our [pom.xml](pom.xml) like [this](pom.xml#L96-L111).

Note that [the `timestampedReports` configuration](pom.xml#L101) will cause [Pitest] to not put its reports into timestamped directories but overwrite old reports. This makes it easier to find the report after running the analysis.

Also note that [the `execution` configuration](pom.xml#L103-L110) will cause [Pitest] to run every time you run `mvn install` or `verify`. Since mutation testing takes a lot of time you might want to move this into a profile or just run `mvn install pitest:mutationCoverage` manually.

Objectives
----------
- [ ] Checkout [User] and [UserClassSpec].
- [ ] Run Pitest via `mvn install pitest:mutationCoverage`, open the [report] and try to understand it.
- [ ] Try to "kill" the remaining mutations one by one.


[Pitest]: <http://pitest.org>
[Groovy]: <http://www.groovy-lang.org/>
[Spock]: <https://github.com/spockframework/spock>
[JUnit]: <http://junit.org>

[User]: <src/main/java/de/assertagile/workshop/pitest/User.java>
[UserClassSpec]: <src/test/groovy/de/assertagile/workshop/pitest/UserClassSpec.groovy>
[report]: <target/pit-reports/de.assertagile.workshop.pitest/index.html>