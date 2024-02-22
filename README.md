# Documentation

# Endpoint Examples

## Person

GET(ALL) localhost:8080/api/v1/person
GET(ONE) localhost:8080/api/v1/person/can@gmail.com
PUT localhost:8080/api/v1/person/can@gmail.com
Body Example in JSON:
{
    "email": "can@gmail.com",
    "password": "hey",
    "role": "admin",
    "name": null,
    "age": 0
}

POST localhost:8080/api/v1/person
Body Example in JSON:
{
    "email": "can@gmail.com",
    "password": "123",
    "role": null,
    "name": null,
    "age": 0 
}

DELETE localhost:8080/api/v1/person/can@gmail.com

## Beacon

GET(ALL) localhost:8080/api/v1/beacon
GET(ONE) localhost:8080/api/v1/person/123
PUT localhost:8080/api/v1/beacon/123
Body Example in JSON:
{
    "mac": "123",
    "x": 1,
    "y": 2
}

POST localhost:8080/api/v1/beacon
Body Example in JSON:
{
    "mac": "123",
    "x": 1,
    "y": 2
}

DELETE localhost:8080/api/v1/beacon/123

## Department

GET(ALL) localhost:8080/api/v1/department
GET(ONE) localhost:8080/api/v1/department/3931227c-667a-4df7-a950-d49d62368c66
PUT localhost:8080/api/v1/department/3931227c-667a-4df7-a950-d49d62368c66
Body Example in JSON:
{
    "id":"3931227c-667a-4df7-a950-d49d62368c66",
    "name":"asd"
}

POST localhost:8080/api/v1/department
Body Example in JSON:
{
    "id":"3931227c-667a-4df7-a950-d49d62368c66",
    "name":"asd"
}

DELETE localhost:8080/api/v1/department/3931227c-667a-4df7-a950-d49d62368c66

## Order

GET(ALL) localhost:8080/api/v1/order
GET(ONE) localhost:8080/api/v1/order/3931227c-667a-4df7-a950-d49d62368c66
PUT localhost:8080/api/v1/order/3931227c-667a-4df7-a950-d49d62368c66
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "customerId": "3931227c-667a-4df7-a950-d49d62368c66",
    "productId": "3931227c-667a-4df7-a950-d49d62368c66",
    "description": null,
    "quantity": 0,
    "time": null
}

POST localhost:8080/api/v1/order
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "customerId": "3931227c-667a-4df7-a950-d49d62368c66",
    "productId": "3931227c-667a-4df7-a950-d49d62368c66",
    "description": null,
    "quantity": 0,
    "time": null
}

DELETE localhost:8080/api/v1/order/3931227c-667a-4df7-a950-d49d62368c66

## Position

GET(ALL) localhost:8080/api/v1/position
GET(ONE) localhost:8080/api/v1/position/3931227c-667a-4df7-a950-d49d62368c66
PUT localhost:8080/api/v1/position/3931227c-667a-4df7-a950-d49d62368c66
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "customerId": "3931227c-667a-4df7-a950-d49d62368c66",
    "x": 0,
    "y": 0,
    "time": null
}

POST localhost:8080/api/v1/position
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "customerId": "3931227c-667a-4df7-a950-d49d62368c66",
    "x": 0,
    "y": 0,
    "time": null
}

DELETE localhost:8080/api/v1/position/3931227c-667a-4df7-a950-d49d62368c66

## Product

GET(ALL) localhost:8080/api/v1/product
GET(ONE) localhost:8080/api/v1/product/3931227c-667a-4df7-a950-d49d62368c66
PUT localhost:8080/api/v1/product/3931227c-667a-4df7-a950-d49d62368c66
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "sectionId": "3931227c-667a-4df7-a950-d49d62368c66",
    "name": "asd",
    "description": null,
    "stock": 0,
    "price": 0.0
}

POST localhost:8080/api/v1/product
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "sectionId": "3931227c-667a-4df7-a950-d49d62368c66",
    "name": "asd",
    "description": null,
    "stock": 0,
    "price": 0.0
}

DELETE localhost:8080/api/v1/product/3931227c-667a-4df7-a950-d49d62368c66

## Section

GET(ALL) localhost:8080/api/v1/section
GET(ONE) localhost:8080/api/v1/section/3931227c-667a-4df7-a950-d49d62368c66
PUT localhost:8080/api/v1/section/3931227c-667a-4df7-a950-d49d62368c66
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "departmentId": "3931227c-667a-4df7-a950-d49d62368c66",
    "name": "asd",
    "x1": 0,
    "y1": 0,
    "x2": 0,
    "y2": 0
}

POST localhost:8080/api/v1/section
Body Example in JSON:
{
    "id": "3931227c-667a-4df7-a950-d49d62368c66",
    "departmentId": "3931227c-667a-4df7-a950-d49d62368c66",
    "name": "asd",
    "x1": 0,
    "y1": 0,
    "x2": 0,
    "y2": 0
}

DELETE localhost:8080/api/v1/section/3931227c-667a-4df7-a950-d49d62368c66
