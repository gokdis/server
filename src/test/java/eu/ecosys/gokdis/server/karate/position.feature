Feature: Person Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all positions (GET /position)
    Given path '/position'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].id == '#string'
    And match each $[*].customerId == '#string'
    And match each $[*].x == '#number'
    And match each $[*].y == '#number'
    And match each $[*].time == '#string'


  Scenario: Retrieve position by id (GET /position/{id})
    Given path '/position'
    And header Authorization = authHeader
    And path id = ''
    When method get
    Then status 200
    And match $.id == '#string'
    And match $.customerId == '#string'
    And match $.x == '#number'
    And match $.y == '#number'
    And match $.time == '#string'


  Scenario: Update person by id (PUT /position/{id})
    Given path '/position'
    And header Authorization = authHeader
    And path email = 'kerberos@gokdis.ecosys.eu'
    And request {}
    When method put
    Then status 200
    And match $.name == 'Priam'


  Scenario: Save a new position (POST /position)
    Given path '/position'
    And header Authorization = authHeader
    And request {}
    When method post
    Then status 200
    And match $.id == ''


  Scenario: Delete position by id (DELETE /position/{id})
    Given path '/position'
    And header Authorization = authHeader
    And path id = ''
    When method delete
    Then status 200