# API Cadastro

Api desenvolvida para o teste de desenvolvedor Back-end

## 🚀 Começando

API desenvolvida em Java 18 com Spring Boot, foi utilizado o Banco de dados
PostgreSql para persistência dos dados.

Ir no application.properties e colocar as crendenciais de banco de dados.

### 🔩 Métodos

Foi desenvolvido um CRUD completo.

Link para os testes com POSTMAN:
https://www.getpostman.com/collections/8b9371d7029e6dc167ac

Rotas:

    POST http://localhost:8080/api/v1/company

    GET http://localhost:8080/api/v1/company

    GET http://localhost:8080/api/v1/company/{id}

    DELETE http://localhost:8080/api/v1/company/{id}

    PUT http://localhost:8080/api/v1/company/{id}

Exemplo de body:
{
    "name": "name",
    "cnpj": "1298391283",
    "observations": "laksdlkas",
    "startDate": "29/04/2022",
    "endDate": "29/04/2022",
    "property": {
        "id": 2121,
        "name":"teste"
    },
    "laboratory": {
        "id":2121,
        "name":"teste1"
    }
}


## ✒️ Autores

* **Desenvolvedor** - Jorge Soares - [jorgesoares](https://github.com/jsfj)
