Feature: ||User Details||
  1. Verify user by page id

  Scenario Outline: Verify user by page id
    Given User has a page id "<pageId>"
    And User call user info api
    Then Verify users data
    Examples:
      | pageId |
      | 2       |