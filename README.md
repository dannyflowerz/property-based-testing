# property-based-testing
Sample Java project to introduce the concept of property based testing.

### How to use
This is a very simple mortgage calculator app that implements the following business rules:
- You can take a mortgage alone or with your partner
- Your (combined) yearly income needs to be at least €20.000
- The amount of mortgage you can get is
    - 3,5 x (combined) yearly income for €20.000 - €29.999
    - 4,4 x (combined) yearly income for €30.000 - €59.999
    - 4,6 x (combined) yearly income for €60.000 - €89.999
    - 4,8 x (combined) yearly income for €90.000 - €119.999
    - 5 x (combined) yearly income for €120.000 of higher

You don't even need to look at the implementation, just go through the unit test classes in the following order:
1. SimpleMortgageCalculatorTest
2. SimpleMortgageCalculatorAdvancedTest
3. SimpleMortgageCalculatorPropertyBasedTest

### Conclusion
You can see that SimpleMortgageCalculatorPropertyBasedTest covers much more than SimpleMortgageCalculatorTest and SimpleMortgageCalculatorAdvancedTest combined, in a concise way, that is much closer to how the business rules were originally defined. 

### Heads-up
Some of the unit tests fail, but that's the point ;)
