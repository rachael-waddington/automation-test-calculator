# automation-test-calculator

Tests are executed using the Android Instrumented Tests configuration. 
Currently there are 3 failing in CalculatorTest:
  - canModuloNumbers(): In-app modulo not calculating results corrently (unit tests also failing)
  - canEnterLargeNumbers(): When entering numbers over 16 digits the number changes 
  - canParseImaginaryNumbers(): Cannot enter a negative number until equals is pressed, entering `-1.0 ROOT` doesn't take into account the negative and just roots positive 1
  
### Page object model:  
The base page object is used to store all common methods for pages, such as clicking and assertions; 
    if this got very large in the future I'd rather move assertions and actions into two separate helper files called by BasePage.

The helpers package currently just consists of an enum used to store the operator values.

All other pages extend BasePage (including the action bar) and store all methods specific to that page; 
    the widget is not tested using Espresso and could be done with UIAutomator.
    
### Tests:
The tests are written in plain English as much as possible, in the format `Page().action().nextAction().assertThis()` and should be readable and easy to follow for anyone.

The calculator itself has the highest coverage as it will get the most use/traffic, coverage includes all button actions and long and imaginary number corner cases. 

Both the settings and about pages only have a single simple navigation test as the priority of this is lower; 
    in the future more tests would be added to assert the layout is correct & toggles function if deemed necessary. 
I would recommend more niche/complicated cases such as colour customisation are covered by exploratory testing.
