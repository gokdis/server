Feature: Order Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all orders (GET /order)
    Given path '/order'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].id == '#string'
    And match each $[*].personEmail == '#string'
    And match each $[*].productId == '#string'
    And match each $[*].description == '#string'
    And match each $[*].quantity == '#number'
    And match each $[*].time == '#string'

  Scenario: Retrieve order by id (GET /order/{id})
    Given path '/order'
    And header Authorization = authHeader
    And path id = 'e9b95f60-49ba-4be6-b565-420a262b840f'
    When method get
    Then status 200
    And match $.id == 'e9b95f60-49ba-4be6-b565-420a262b840f'
    And match $.productId == 'fb711ca3-17b0-4094-864a-ce02fde0e853'

  Scenario: Update order by id (PUT /order/{id})
    Given path '/order'
    And header Authorization = authHeader
    And path id = 'e9b95f60-49ba-4be6-b565-420a262b840f'
    And request {"id": "e9b95f60-49ba-4be6-b565-420a262b840f","personEmail": "helen@gokdis.ecosys.eu","productId": "fb711ca3-17b0-4094-864a-ce02fde0e853","description": "new product","quantity": 50,"time": "2024-03-25T12:40:36.416+00:00"}
    When method put
    Then status 200
    And match $.quantity == 50

  Scenario: Save a new order (POST /order)
    Given path '/order'
    And header Authorization = authHeader
    And request {"id": "e9b95f60-49ba-4be6-b565-420a262b8404","personEmail": "helen@gokdis.ecosys.eu","productId": "fb711ca3-17b0-4094-864a-ce02fde0e852","description": "new product2","quantity": 50,"time": "2024-03-25T12:40:36.416+00:00"}
    When method post
    Then status 200
    And match $.id == 'e9b95f60-49ba-4be6-b565-420a262b8404'
    And match $.personEmail == 'helen@gokdis.ecosys.eu'
    And match $.productId == 'fb711ca3-17b0-4094-864a-ce02fde0e852'
    And match $.description == 'new product2'
    And match $.quantity == 50

  Scenario: Delete order by id (DELETE /order/{id})
    Given path '/order'
    And header Authorization = authHeader
    And path id = 'e9b95f60-49ba-4be6-b565-420a262b8404'
    When method delete
    Then status 200