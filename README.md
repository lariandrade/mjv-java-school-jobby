<div align="center">
    <img src="https://github.com/lariandrade/mjv-java-school-jobby/assets/44838761/649eac87-ed6f-4975-b95f-1599d47c2338" weight="350" height="250"/>
    <h1 align="center">API Rest Jobby</h1>
</div>
<div align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=GREEN&style=for-the-badge"/>
</div>

## Descrição do Projeto
Plataforma destinada ao armazenamento de dados pessoais e profissionais para em seguida proporcionar uma listagem de profissionais, suas experiências e habilidades destinadas para auxilar no processo de recrutamento e seleção de uma empresa de tecnologia. 

## Proposta
Para o desafio foi fornecido o seguinte diagrama:

![image](https://github.com/lariandrade/mjv-java-school-jobby/assets/44838761/c86dbf69-7499-4fbf-98c4-df6001820aa3)

## Funcionalidades
- CRUD Candidatos
- CRUD Experiencias profissionais

## ✅ Tecnologias utilizadas

O projeto foi construído utilizando as seguintes ferramentas e tecnologias:

- Java 17
- Maven
- Spring Boot 3
- Spring Data JPA
- SpringDoc OpenAPI 3


## ▶️ Rodar a aplicação
1. Baixe o projeto:
```
git clone https://github.com/lariandrade/mjv-java-school-jobby.git
```
Abra o projeto na IDE.

2. Configurando o banco de dados

Antes de executar a aplicação, certifique-se de criar o banco de dados necessário no MySQL. Use o seguinte comando para criar:
```
CREATE DATABASE jobby;
```
3. Configurando as credenciais de acesso ao banco de dados

No arquivo `application.properties`, localize as configurações de acesso ao banco de dados e insira suas próprias credenciais:
```
spring.datasource.username=<insira seu nome de usuario>
spring.datasource.password=<insira sua senha>
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Endpoints

### Candidatos
![image](https://github.com/lariandrade/mjv-java-school-jobby/assets/44838761/7eed12d4-b078-446f-ba7f-c01746a65dc9)

### Experiencias
![image](https://github.com/lariandrade/mjv-java-school-jobby/assets/44838761/18aad81c-2c7b-4e9a-8568-8cc2ce4978e4)

Após cadastrar o candidato e fornecer suas experiências profissionais, o JSON resultante para as requisições GET do candidato ficará da seguinte maneira:

```
{
    "id": 8,
    "nome": "larissa",
    "cpf": "123.456.789-10",
    "dataNascimento": "1997-08-23",
    "telefone": 911111111,
    "email": "larissa@gmail.com",
    "habilidades": "Java, Spring, MySQL",
    "sexo": "FEMININO",
    "celular": {
        "numero_celular": 1234567890,
        "whatsapp": true
    },
    "endereco": {
        "cep": 13212000,
        "logradouro": "Rua Flores",
        "numero": "4245",
        "complemento": null,
        "bairro": "Colonia",
        "cidade": {
            "id": 8,
            "nome": "Jundiaí",
            "estado": "São Paulo",
            "sigla": "SP"
        }
    },
    "pretencaoSalarial": {
        "valorMinimo": 1567.64,
        "valorMaximo": 2500.00
    },
    "profissao": {
        "id": 8,
        "nome": "programadora"
    },
    "experiencias": [
        {
            "id": 6,
            "nomeEmpresa": "Microsoft",
            "salario": 3500.0,
            "empregoAtual": false,
            "dataContratacao": "2023-07-14",
            "dataDesligamento": "2023-07-15",
            "regimeContratacao": "CLT",
            "profissao": {
                "id": 8,
                "nome": "programadora"
            }
        }
    ]
}

```

