<div align="center">
    <img src="https://github.com/lariandrade/mjv-java-school-jobby/assets/44838761/649eac87-ed6f-4975-b95f-1599d47c2338" weight="350" height="250"/>
    <h1 align="center">API Rest Jobby</h1>
</div>
<div align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=GREEN&style=for-the-badge"/>
</div>

## Descrição do Projeto
Plataforma destinada ao armazenamento de dados pessoais e profissionais para em seguida proporcionar uma listagem de profissionais, suas experiências e habilidades destinadas para auxilar no processo de recrutamento e seleção de uma empresa de tecnologia. 

## ▶️ Rodar a aplicação
1. Baixe o projeto:
```
git clone https://github.com/lariandrade/mjv-java-school-jobby.git
```
Abra o projeto na IDE.

2. Configurando o Banco de Dados

Antes de executar a aplicação, certifique-se de criar o banco de dados necessário no MySQL. Use o seguinte comando para criar:
```
CREATE DATABASE jobby;
```
3. Configurando as Credenciais de Acesso ao Banco de Dados

No arquivo `application.properties`, localize as configurações de acesso ao banco de dados e insira suas próprias credenciais:
```
spring.datasource.username=<insira seu nome de usuario>
spring.datasource.password=<insira sua senha>
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Endpoints
A API poderá ser acessada em [localhost:8080](http://localhost:8080)

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Candidatos

- POST
```
http://localhost:8080/candidatos
```

- GET
```
http://localhost:8080/candidatos -> lista todos
http://localhost:8080/candidatos/{id} -> lista apenas um

```

- PUT
```
http://localhost:8080/candidatos/{id}

```

- DELETE
```
http://localhost:8080/candidatos/{id}
```
