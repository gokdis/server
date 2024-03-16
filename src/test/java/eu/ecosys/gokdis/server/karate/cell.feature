Feature: Cell Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all cells (GET /cell/all)
    Given path '/cell/all'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].x == '#number'
    And match each $[*].y == '#number'
    And match each $[*].sectionId == '#string'


  Scenario: Retrieve cell by coordinates (GET /cell/{x}/{y})
    Given path '/cell'
    And header Authorization = authHeader
    And path x = 592
    And path y = 672
    When method get
    Then status 200
    And match $.x == 592
    And match $.y == 672
    And match $.sectionId == '7b580377-ca5c-4326-a235-25898711e5da'


  Scenario: Save a new cell (POST /cell)
    Given path '/cell'
    And header Authorization = authHeader
    And request { "x": 1, "y": 2, "sectionId": "408ce76e-c6c1-4819-a47a-456627dd7d56" }
    When method post
    Then status 200
    And match $.x == 1
    And match $.y == 2
    And match $.sectionId == '408ce76e-c6c1-4819-a47a-456627dd7d56'

  Scenario: Delete cell by coordinates (DELETE /cell/{x}/{y})
    Given path '/cell'
    And header Authorization = authHeader
    And path x = 1
    And path y = 2
    When method delete
    Then status 200