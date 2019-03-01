Feature: Bank account features

  Scenario: Making a deposit
    Given a bank account
    When I deposit 278.13 on 2019/03/01
    Then bank account balance should be 278.13

  Scenario: Making a withdrawal
    Given a bank account
    When I withdrawal 427.32 on 2019/03/01
    Then bank account balance should be -427.32