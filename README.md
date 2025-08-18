# Forum Hub&emsp;![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" /><img src="https://img.shields.io/badge/json-5E5C5C?style=for-the-badge&logo=json&logoColor=white" />
O Challenge Forum Hub, é um projeto final oferecido pela alura Challenge Back-End (Oracle Next Education).

- **objetivo**

> desenvolvido em beck end java, utilizando API Rest.

- **o que encontrar**

> autenticação utilizando token, login com usuário e senha cadastrado no banco de dados; validações utilizando as requisições GET, POST, PUT e DELETE, segurança com autenticação stateless via Tokens JWT e persistência de dados.

- **tecnologias**

> java, Spring Boot, Spring Security (JWT), Spring Data JPA, Flyway (Migrations), MySQL, Swagger/OpenAPI.

- **dependências**

> .

## Compilando e Executando o Forum Hub
Certifique-se de ter o [intelliJ](https://www.jetbrains.com/idea/download/?section=windows) e o [postman](https://www.postman.com/downloads/):

1. Faça o download do código fonte:

```sh
https://github.com/maumauriciog/Challenge_Forum_Hub
```

2. Configure o acesso no arquivo application.properties, encontrado projeto:

```
spring.datasource.url=jdbc:mysql://localhost:3306/<nome do banco de dados>
spring.datasource.username=root
spring.datasource.password=<senha acesso ao mySql>

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

api.security.token.secret=${<nome da variável de ambiente, no S.O, onde estará a senha>:<senha que será utilizada, caso não encontre a variável de ambiente>}
```

3. postman:
&emsp;&emsp;<img src="pictures/postman.png" width="838">

```
configure o postman para realizar os testes de autenticação utilizando token, usuário e senha cadastrado via json no banco de dados. 
```

> [!IMPORTANT]
> O programa funciona somente utilizando uma IDE, neste caso, o [intelliJ](https://www.jetbrains.com/idea/download/?section=windows) com a biblioteca [GSON](https://mvnrepository.com/search?q=GSON) instalada.

## Utilizando o Programa em Execução
O usuário terá de escolher uma das 06(seis) opções disponíveis conforme abaixo:
```bash
-----------------------------------------------
---- SEJA BEM VINDO AO CONVERSOR DE MOEDAS ----
-----------------------------------------------
1). Dolar -> Peso Argentino
2). Peso Argentino -> Dolar
3). Dolar -> Real Brasileiro
4). Real Brasileiro -> Dolar
5). Dolar -> Peso Colombiano
6). Peso Colombiano -> Dolar
7). Sair

-> Escolha uma opção válida: 4
-> Digite o valor que deseja converter: 100
```
```bash
     *** Resultado da Operação ***
     Valor de 100.0[BRL], corresponde ao valor final de 17.52[USD]
```

## Contribuindo
Esperamos que outras organizações possam se beneficiar do projeto. Agradecemos qualquer contribuição da comunidade.

## Contato
Temos os seguintes canais para contato:
- maumauriciog@hotmail.com
  - `no campo Assunto escreva: Ajuda` para assuntos de como utilizar o sistema; e
  - `no campo Assunto escreva: Quero Contribuir` para aqueles que desejam contribuir.
- [GitHub](https://github.com/maumauriciog)


## Licensa
```
The MIT License (MIT)

Copyright (c) 2025 Maurício Gomes das Chagas

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
