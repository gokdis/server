Feature: Person Tests
  Background:
    * url baseUrl
    * def authHeader = 'Basic aGVsZW5AZ29rZGlzLmVjb3N5cy5ldTpoZWxlbg=='

  Scenario: Retrieve all persons (GET /person)
    Given path '/person'
    And header Authorization = authHeader
    When method get
    Then status 200
    And match each $[*].email == '#string'
    And match each $[*].password == '#string'
    And match each $[*].role == '#string'
    And match each $[*].name == '#string'
    And match each $[*].surname == '#string'
    And match each $[*].age == '#number'
    And match each $[*].gender == '#string'

  Scenario: Retrieve person by email (GET /person/{email})
    Given path '/person'
    And header Authorization = authHeader
    And path email = 'helen@gokdis.ecosys.eu'
    When method get
    Then status 200
    And match $.email == 'helen@gokdis.ecosys.eu'
    And match $.name == '#string'

  Scenario: Update person by email (PUT /person/{email})
    Given path '/person'
    And header Authorization = authHeader
    And path email = 'kerberos@gokdis.ecosys.eu'
    And request { "email": "kerberos@gokdis.ecosys.eu", "password": "kerberos", "role": "ROLE_MOD", "name": "Priam", "surname": "of Troy", "age": 30, "gender": "Male" }
    When method put
    Then status 200
    And match $.name == 'Priam'
    And match $.age == 30
    And match $.gender == 'Male'

  Scenario: Save a new person (POST /person)
    Given path '/person'
    And header Authorization = authHeader
    And request { "email": "hector@gokdis.ecosys.eu", "password": "hector", "role": "ROLE_USER", "name": "Hector", "surname": "of Troy", "age": 23, "gender": "Male" }
    When method post
    Then status 200
    And match $.email == 'hector@gokdis.ecosys.eu'
    And match $.name == 'Hector'
    And match $.surname == 'of Troy'
    And match $.age == 23
    And match $.gender == 'Male'

  Scenario: Delete person by email (DELETE /person/{email})
    Given path '/person'
    And header Authorization = authHeader
    And path email = 'hector@gokdis.ecosys.eu'
    When method delete
    Then status 200