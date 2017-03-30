package de.assertagile.workshop.pitest

import spock.lang.Specification
import spock.lang.Subject

class MyClassSpec extends Specification {

    @Subject
    MyClass myClass = new MyClass()

    void "add should return the sum of a and b"() {
        expect:
        myClass.add(0, 0) == 0
    }
}
