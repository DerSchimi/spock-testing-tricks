spock-testing-tricks
====================

Some special cases with spock testing

A simple extension to Specification to handle softAsserts.

Using the SoftAssertSpecification as base Specification you are able to run spock tests with so called softAsserts.
All you need to do is call softAssert with a closure defining your assert. No testcase will fail because of this soft asserts.

Check TestSoftAssertSpecification for a basic usage.



