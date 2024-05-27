Feature: ||User Details||
  1. Verify user by page id

  Scenario Outline: Verify user by page ID
    Given the user has a page ID "<pageId>"
    When the user calls the user info API
    And converts the JSON object to a Java object
    Then the user's data is verified

    Examples:
      | pageId |
      | 2      |


  Scenario Outline: Verify user details for user id
    Given User has a user id "<userId>"
    And User call get user by id api
    Then Verify users data for user id
    Examples:
      | userId |
      |        2|
