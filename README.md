Pitest Workshop
===============

Workshop for mutation testing with [Pitest]. In this project I use [Groovy] and [Spock] for testing simply because I 
like it better than [JUnit]. However [Pitest] works just fine for [Junit] as well. 

Project Setup with Maven
------------------------
In order to use Pitest into our Maven project we just need to add the plugin ito our [pom.xml](pom.xml) like
[this](pom.xml#L96-L111).

Note that [this configuration](pom.xml#L101) will cause [Pitest] to not put its reports into timestamped directories 
but overwrite old reports. This makes it easier to find the report after running the analysis.

Also note that the [execution](pom.xml#L103-L110) will cause [Pitest] to run every time you run `mvn install` or 
`verify`. Since mutation testing takes a lot of time you might want to move this into a profile or just run
`mvn install pitest:mutationCoverage` manually.

Objectives
----------
- [ ] Checkout [MyClass] and [MyClassSpec]. Note that [MyClassSpec] covers every line/branch in [MyClass].
- [ ] Run `mvn install pitest:mutationCoverage` to generate the [report], open it and try to understand it.
- [ ] Try to "kill" the remaining mutation.


[Pitest]: <http://pitest.org>
[Groovy]: <http://www.groovy-lang.org/>
[Spock]: <https://github.com/spockframework/spock>
[JUnit]: <http://junit.org>

[MyClass]: <src/main/java/de/assertagile/workshop/pitest/MyClass.java>
[MyClassSpec]: <src/test/groovy/de/assertagile/workshop/pitest/MyClassSpec.groovy>
[report]: <target/pit-reports/de.assertagile.workshop.pitest/index.html>