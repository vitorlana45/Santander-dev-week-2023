
# Santander Dev Week 2024
Java RESTful API criada para a Santander Dev Week

## Diagrama de classes

```mermaid

classDiagram
    class User {
        -String name
        -Account account
        -List<Feature> features
        -Card card
        -List<News> news
    }

    class Account {
        -String number
        -String agency
        -String balance
        -String limit
    }

    class Feature {
        -String icon
        -String description
    }

    class Card {
        -String number
        -Float limit
    }

    class News {
        -String icon
        -String description
    }

    User "1" *-- Account
    User "1" *-- "*" Feature
    User "1" *-- Card
    User "1" *-- "*" News

 `````
