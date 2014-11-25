package de.derschimi.spocktricks

import org.spockframework.runtime.ConditionNotSatisfiedError
import spock.lang.Specification

/**
 * This Spock-Specification is ready for softAsserts!
  */
class SoftAssertSpecification extends Specification{
    protected static List<AssertionError> softAsserts = [];


    def setupSpec() {
        softAsserts = []
    }

    def cleanup(){
        if (softAsserts.size() >0){
            throw new RuntimeException("some soft asserts are still available! Did you forgot to call #checkSoftAsserts?");
        }
    }

    /**
     * Please call me at the expect/then block when softAsserts are used.
     * Otherwise you wont get notified about soft asserts.
     */
    public void checkSoftAsserts(){
        // clear before assert, otherwise cleanupSpec wont work as expected
        def copyOfSoftAsserts = softAsserts.collect()
        softAsserts.clear()
        assert copyOfSoftAsserts.size() == 0

    }

    /**
     * Doing a softAssert will not stop this testcase.
     * Instead it will continue, log the ConditionNotSatisfiedError/AssertionError, might fail on cleanup
     * and print all collected errors.
     * @param closure the condition
     */
    public void softAssert(Closure  closure) {
        try {
            closure();
        } catch (ConditionNotSatisfiedError e) {
            softAsserts.add(e);
        } catch (AssertionError ae){
            softAsserts.add(ae);
        }
    }

}
