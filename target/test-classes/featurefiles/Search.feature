Feature: Google Search

  @Regression
  Scenario: Search cricket
    Given open google URL
    And enter "criket"
    When click GoogleSearch
    Then cricket results coming
