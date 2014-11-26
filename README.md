spock-testing-tricks
====================

Some special cases with spock testing

A simple extension to Specification to handle softAsserts.

Using the SoftAssertSpecification as base Specification you are able to run spock tests with so called softAsserts.
All you need to do is call softAssert with a closure defining your assert.
No testcase will fail while running because of this soft asserts.
It might fail when calling checkSoftAsserts at the "expect/then" block of the testcase.

Check TestSoftAssertSpecification for a basic usage.
This Project is just a workaround until Spock hopefully integrated the softAssert feature.
a
