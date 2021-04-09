Feature: The logged in user should be able to search for the desired music artist and then add tracks to favorites


  Background: Login into account with correct credentials
    Given User goes to Mixcloud
    When User click on the login button on page at the site
    And  User enters a correct username
    And  User enters a correct password
    When User click on the login button on the homepage
    Then User must be successfully logged in


  Scenario: Adding and deleting tracks to favorites
    Given User click on the Search field
    When User enter name artist in the Search field
    And  User select any track.
    And User click on the favorites button
    When User click on icon your profile
    And User clicks button your profile
    And  Track should be in the favorites
    Then User clicks remove a track from favorites


