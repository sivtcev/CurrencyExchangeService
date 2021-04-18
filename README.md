# Currency exchange service

## 1.Technologies

1. Maven
2. Spring Boot 2.4.5
3. MySQL 5.7
4. Liquibase 4.3.2

## 2. API description

```GET /exchange/```

#### Request body
Request: user id, amount in source currency, source currency, target currency.

```
{ "id": LONG
  "amount: DOUBLE
  "currency_from": STRING
  "currency_to": STRING
}
```
#### Response body
Response: request id, amount in the target currency.

```
{ "request_id": LONG
  "amount: LONG
}
```
---

```GET /stats/once```

#### Response body
Response: Users who requested a conversion of more than $ 10,000 per request.

```
[{
"user": STRING
"amount": LONG
}...
]
```
---

```GET /stats/total```

#### Response body
Response: Users whose total requested volume is more than $ 100,000.

```
[{
"user": STRING
"amount": LONG
}...
]
```
---

```GET /stats/rating```

#### Response body
Response: Rating of currency conversion destinations by popularity.

```
[{
"from": STRING
"to": STRING
"total_sum": LONG
}...
]
```

## 3.Deployment without Docker

### Preprarations

1. Install Maven
2. Install Lombok plugin for your IDE
3. Install MySQL 5.7
4. Edit src/main/resources/application.yml，change the value of username and password in spring.datasourse according to your settings.

### Run

Execute ```mvn spring-boot:run``` in the root directory of this project. Or run the main method in ```CurrencyExchangeServiceApplication``` class.

### Build

Execute ```mvn clean package```, then deploy ```target/CurrencyExchangeService.war``` to the server.

## 4. Deployment with Docker

1. Execute ```mvn install```
2. Then, ```docker-compose up -d```
