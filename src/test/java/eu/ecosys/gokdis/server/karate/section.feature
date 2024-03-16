Feature: Section Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all sections (GET /section)
    Given path '/section'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].id == '#string'
    And match each $[*].name == '#string'


  Scenario: Save a new section (POST /section)
    Given path '/section'
    And header Authorization = authHeader
    And request { "id": "2e7e3c54-c5c9-4d99-9c6f-fb38117f3126", "name": "Frozen Meat & Seafood 2"}
    When method post
    Then status 200
    And match $.id == '2e7e3c54-c5c9-4d99-9c6f-fb38117f3126'
    And match $.name == 'Frozen Meat & Seafood 2'

  Scenario: Delete section by id (DELETE /section/{id})
    Given path '/section'
    And header Authorization = authHeader
    And path id = '2e7e3c54-c5c9-4d99-9c6f-fb38117f3126'
    When method delete
    Then status 200