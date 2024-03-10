# IUSafe API

## Descrição:

A IUSafe é uma  aplicação Spring Boot, focada no cadastro de seguros, no qual é possível fazer a criação, atualização, exclusão e listagem de seguros.

## Pré-requisitos:

- Java 11 ou superior
- Docker e Docker Compose
- Insomnia

## Configuração do Banco de Dados: 

A aplicação utiliza um banco de dados Postgresql. 
Para iniciar o banco de dados, utilize o Docker Compose contido na pasta raiz do projeto.

```bash
docker-compose up -d
```

## Executando a Aplicação:

Após inicializado o banco, execute a aplicação com o seguinte comando:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponivel em `http://localhost:8080`

## Documentação da API:

A API é documentada usando o Swagger. Com a aplicação em execução você pode acessar a documentação em:
> http://localhost:8080/swagger-ui/index.html


## Como Baixar a Collection do Insomnia

Para testar a API no insomnia você pode importar a collection do Insomnia.
Baixe a collection clicando no link abaixo:
> [Download da Collection do Insomnia](./docs/iuSafeCollection.json)

