 
# [![Build Status](https://travis-ci.com/Mario23junior/Automoveis_api.svg?branch=main)](https://travis-ci.com/Mario23junior/Automoveis_api) 
 
# Spring Boot Projeto de Crud Simples API Automoveis

Este é um projeto experimental de um aplicativo Java/Maven/Spring Boot(versão 2.4.5) que pode ser usado como um iniciador para a criação de um microsserviço com métodos simples e experimentais espero que lhe ajude nas suas futuras ideias.


### Para visualizar sua base de dados H2 em memória

A api e executado no banco de dados H2 na memória. Para visualizar e consultar o banco de dados, você pode navegar para http://localhost:8080/h2-console. O nome de usuário padrão é 'sa' com uma senha em branco.


### Para visualizar a documentação da API via Swagger 2

Execute o servidor e navegue até http://localhost:8080/swagger-ui.html

## Como correr

Este aplicativo é empacotado como um jar que tem Tomcat 8 embutido.
Nenhuma instalação do Tomcat ou JBoss é necessária. Você o executa usando o comando ``` java -jar ```.

* Clone este repositório
* Certifique-se de usar openjdk "11.0.10" ou SDK 8.x  e Maven 3.x
* Depois de construído com sucesso, você pode executar o serviço.
* 
```
        java -jar 
or
        mvn spring-boot:run 
```

