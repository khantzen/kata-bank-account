Feature: Bank account features

  Scenario: Making a deposit
    Given a bank account with 242.36
    When I deposit 278.13 on 2019/03/01
    Then bank account balance should be 520.49

  Scenario: Making a withdrawal
    Given a bank account with 114.00
    When I withdrawal 427.32 on 2019/03/01
    Then bank account balance should be -313.32

  Scenario: Displaying history
    Given a bank account with 780.25
    When I deposit 1423.35 on 2019/03/01
    When I withdrawal 542.36 on 2017/02/23
    When I deposit 745.28 on 2020/04/02
    When I ask for my bank account operation history
    Then I should have
    """
    | Date       |  Amount  | Balance  |
    | 2020/04/02 | +745.28  | +2406.52 |
    | 2019/03/01 | +1423.35 | +1661.24 |
    | 2017/02/23 | -542.36  | +237.89  |
    """