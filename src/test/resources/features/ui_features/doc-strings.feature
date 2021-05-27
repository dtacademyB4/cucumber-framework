Feature: Doc String demo

#  Doc Strings are handy for passing a larger piece of text to a step definition.
#
#  The text should be offset by delimiters consisting of three double-quote marks on lines of their own   """    """:



  Scenario:  Doc string demo
    Given The API endpoint is up and running
    When I send post request by passing this body
           """
           {
            "name":"John",
            "age":30,
            "cars": {
            "car1":"Ford",
            "car2":"BMW",
            "car3":"Fiat"
            }
            }
            """
    Then The response should be correct