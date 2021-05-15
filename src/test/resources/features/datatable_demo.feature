Feature: Datatable demo


  Scenario: Whatever
    Given The precondition is satisfied
    When The action is done
    Then The result should contain this information

      | hi              |
      | hello           |
      | hola            |
      | how is it going |
      | what's up       |
    #     List <String>
  @temp
  Scenario: Whatever
    Given The precondition is satisfied
    When The action is done
    Then The result should contain this information as
      | firstName   | lastName | birthDate  |
      | Annie M. G. | Schmidt  | 1911-03-20 |
      | Roald       | Dahl     | 1916-09-13 |
      | Astrid      | Lindgren | 1907-11-14 |
