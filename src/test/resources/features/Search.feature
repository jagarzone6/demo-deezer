Feature: Use Deezer API endpoint Search to find tracks, albums and artists

  Scenario Outline: Search a Track by Name.
    Given I have a track name "<track>"
    When I search using API Search method track
    Then I should receive a list of tracks related to that name
    And The tracks should have title including the track name I searched


    Examples:
      |track|
      |The Millionaire Waltz|


  Scenario Outline: Search a Track by Title and find the albums where is this track included.
    Given I have a track name "<track>"
    When I search using API Search method track
    Then I should receive a list of tracks related to that name
    And I can get the albums list where this track is present and print their title

    Examples:
      |track|
      |The Millionaire Waltz|

  Scenario Outline: Search a Track by Title and find the artists related to this track.
    Given I have a track name "<track>"
    When I search using API Search method track
    Then I should receive a list of tracks related to that name
    And I can get the artist list related to this track and print their name

    Examples:
      |track|
      |The Millionaire Waltz|

  Scenario Outline: Search a Track by Title and check the track ID is not null
    Given I have a track name "<track>"
    When I search using API Search method track
    Then I should receive a list of tracks related to that name
    And Their track id should not be null
    Examples:
      |track|
      |The Millionaire Waltz|