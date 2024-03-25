Feature: Product Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all products (GET /product)
    Given path '/product'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].id == '#string'
    And match each $[*].sectionId == '#string'
    And match each $[*].name == '#string'
    And match each $[*].description == '#string'
    And match each $[*].stock == '#number'
    And match each $[*].price == '#number'

  Scenario: Save a new product (POST /product)
    Given path '/product'
    And header Authorization = authHeader
    And request  {"id": "fb711ca3-17b0-4094-864a-ce02fde0e810","sectionId": "5de7b96e-8b47-4194-84a9-4af579dee168","name": "Tooth Paste","description": "new","stock": 40,"price": 2.0}
    When method post
    Then status 200
    And match $.id == 'fb711ca3-17b0-4094-864a-ce02fde0e810'
    And match $.sectionId == '5de7b96e-8b47-4194-84a9-4af579dee168'
    And match $.name == 'Tooth Paste'
    And match $.description == 'new'
    And match $.stock == 40
    And match $.price == 2.0

  Scenario: Update product by id (PUT /product/{id})
    Given path '/product'
    And header Authorization = authHeader
    And path id = '7a8b8d71-ee3e-4a05-9241-24e001b73852'
    And request {"id": "7a8b8d71-ee3e-4a05-9241-24e001b73852","sectionId": "2c95bf8a-62f0-49e4-bb1e-8ffa6e18a8f3","name": "new product 2","description": "new","stock": 40,"price": 2.0}
    When method put
    Then status 200
    And match $.id == '7a8b8d71-ee3e-4a05-9241-24e001b73852'
    And match $.sectionId == '2c95bf8a-62f0-49e4-bb1e-8ffa6e18a8f3'
    And match $.name == 'new product 2'
    And match $.description == 'new'
    And match $.stock == 40
    And match $.price == 2.0

  Scenario: Delete product by id (DELETE /product/{id})
    Given path '/product'
    And header Authorization = authHeader
    And path id = 'fb711ca3-17b0-4094-864a-ce02fde0e810'
    When method delete
    Then status 200