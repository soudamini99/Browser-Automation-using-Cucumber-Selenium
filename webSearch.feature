//Contains two test scenarions.
  //First one is a successful search of the given phrase which displays it's related links.
  // Second one is an Unsuccessful search which doesn't contain any related links . It displays no results found for the given search by the browser
  // Second one is an Unsuccessful search which doesn't contain any related links . It displays no results found for the given search by the browser

Feature: WebSearch
  @Suceesfulsearch
  Scenario: Finding the phrase Suceesfully
    Given I am on the Google search page
    When I search for "apple"
    Then the page should display results of  "apple"

  @Unsuccessfulsearch
    Scenario: No Results found for phrase
    Given I am on the Google search page
    When I search for "vtyfre53666654#$%^gv56gvhjvfdfgh@#$%^&*"
    Then the page should display results of  "vtyfre53666654#$%^gv56gvhjvfdfgh@#$%^&*"