package de.derschimi.spocktricks

import spock.lang.Specification

/**
 */
class TestSoftAssertSpecification extends SoftAssertSpecification {

    def "simple demo"() {
        when:
        // some simple softAsserts
        softAssert { assert 1 == 2 }
        softAssert { assert 2 == 2 }
        softAssert { assert System.getProperty("os.name") == 'linux' }


        then:
        //  now we check if any soft asserts occured
        checkSoftAsserts()
    }

    def "simple demo that won't fail"() {
        when:
        // some simple softAsserts
        softAssert { assert 1 == 2 }
        softAssert { assert 2 == 2 }
        softAssert { assert System.getProperty("os.name") == 'linux' }


        then:
        //  you should not do this!
        softAsserts.size() == 2
        softAsserts.clear()

    }


}
