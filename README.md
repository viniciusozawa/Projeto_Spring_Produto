# Products API

Projeto de estudos para praticar desenvolvimento de APIs REST com **Spring Boot** e conteinerização com **Docker**.

A ideia aqui é aprender na prática: montar uma API simples de produtos (CRUD), conectar a um banco **MySQL** e colocar tudo para rodar com **Docker Compose**.

## Tecnologias

- Java 25 (Eclipse Temurin)
- Spring Boot 4 (Web, Data JPA, Validation)
- MySQL 8.4
- Docker e Docker Compose
- Maven

## Como rodar

Pré-requisito: ter o [Docker](https://www.docker.com/) instalado.

```bash
git clone <url-do-repositorio>
cd productsapi
docker compose up --build
```

Isso sobe dois containers:

| Container     | Descrição            | Porta  |
|---------------|----------------------|--------|
| `productsapi` | API Spring Boot      | `8080` |
| `mysql`       | Banco de dados MySQL | `3306` |

Para parar tudo:

```bash
docker compose down
```

## Endpoints

| Método | Rota             | Descrição                |
|--------|------------------|--------------------------|
| GET    | `/products`      | Lista todos os produtos  |
| POST   | `/products`      | Cria um produto          |
| PUT    | `/products/{id}` | Atualiza um produto      |
| DELETE | `/products/{id}` | Remove um produto        |

Exemplo de corpo para `POST` e `PUT`:

```json
{
  "name": "Teclado",
  "description": "Mecânico",
  "price": 199.9
}
```

## Contribuindo

Este é um projeto de estudos, então **toda ajuda é bem-vinda!** 🙌

Se você também está aprendendo e quer praticar, ou se encontrou algo que pode melhorar, fique à vontade para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua alteração (`git checkout -b feat/minha-melhoria`)
3. Faça commit das suas mudanças (`git commit -m "feat: minha melhoria"`)
4. Envie para o seu fork (`git push origin feat/minha-melhoria`)
5. Abra um Pull Request

Sugestões, correções, novas funcionalidades ou até melhorias neste README são bem-vindas. Também dá para abrir uma issue com dúvidas ou ideias.
