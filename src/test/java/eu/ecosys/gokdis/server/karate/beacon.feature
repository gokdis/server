Feature: Beacon Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all persons (GET /beacon)
    Given path '/beacon'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].mac == '#string'
    And match each $[*].id == '#string'
    And match each $[*].x == '#number'
    And match each $[*].y == '#number'


  Scenario: Retrieve beacon by mac (GET /beacon/{mac})
    Given path '/beacon'
    And header Authorization = authHeader
    And path mac = 'f5:e5:8c:26:db:7a'
    When method get
    Then status 200
    And match $.mac == 'f5:e5:8c:26:db:7a'
    And match $.id == '#string'

  Scenario: Update beacon by mac (PUT /beacon/{mac})
    Given path '/beacon'
    And header Authorization = authHeader
    And path mac = 'f5:e5:8c:26:db:7a'
    And request { "mac": "f5:e5:8c:26:db:7a", "id": "123", "x": 2, "y": 3 }
    When method put
    Then status 200
    And match $.mac == 'f5:e5:8c:26:db:7a'
    And match $.x == 2
    And match $.y == 3

  Scenario: Save a new beacon (POST /beacon)
    Given path '/beacon'
    And header Authorization = authHeader
    And request { "mac": "f5:e5:8c:26:db:7b", "id": "123", "x": 2, "y": 3 }
    When method post
    Then status 200
    And match $.mac == 'f5:e5:8c:26:db:7b'
    And match $.id == '123'
    And match $.x == 2
    And match $.y == 3

  Scenario: Delete beacon by mac (DELETE /beacon/{mac})
    Given path '/beacon'
    And header Authorization = authHeader
    And path mac = 'f5:e5:8c:26:db:7b'
    When method delete
    Then status 200