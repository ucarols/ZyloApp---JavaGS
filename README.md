# ZyloApp - Backend Java Spring Boot

## 🔧 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (JWT)
- Spring Validation
- Swagger/OpenAPI 3
- Lombok
- Banco de Dados: Oracle
- Maven

---

## 🔐 Funcionalidades

- Cadastro de usuário (`POST /api/auth/register`)
- Login com JWT (`POST /api/auth/login`)
- Listagem de usuários (`GET /api/usuarios`)
- Buscar usuário por ID (`GET /api/usuarios/{id}`)
- Atualizar dados do usuário (`PUT /api/usuarios/{id}`)
- Deletar usuário (`DELETE /api/usuarios/{id}`)
- Documentação via Swagger

---

## 🚀 Como executar localmente

### 1. Clone o repositório

```bash
git clone https://github.com/ucarols/ZyloApp---JavaGS.git
cd ZyloApp---JavaGS
```

### 2. Configure o banco de dados Oracle no arquivo:

`src/main/resources/application.properties`

Exemplo:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=rm559123
spring.datasource.password=fiap
```

### 3. Compile e execute o projeto

```bash
./mvnw spring-boot:run
```

---

## 🔑 Endpoints Principais

### Autenticação

| Método | Rota               | Descrição                |
|--------|--------------------|--------------------------|
| POST   | /api/auth/register | Cadastro de novo usuário |
| POST   | /api/auth/login    | Login e retorno do token |

### Usuários

| Método | Rota                | Descrição                |
|--------|---------------------|--------------------------|
| GET    | /api/usuarios       | Listagem com paginação   |
| GET    | /api/usuarios/{id}  | Buscar usuário por ID    |
| PUT    | /api/usuarios/{id}  | Atualizar dados          |
| DELETE | /api/usuarios/{id}  | Deletar usuário          |

---

## 📑 Documentação Swagger

Após iniciar o projeto, acesse no navegador:

- http://localhost:8080/swagger-ui/index.html

---

## 📂 Estrutura de Pastas

```bash
com.zyloapp
├── config         # Configurações do Swagger
├── controller     # Endpoints REST
├── dto            # Objetos de transferência de dados
├── model          # Entidades JPA
├── repository     # Interfaces de repositório
├── security       # JWT, filtros e configuração
├── service        # Regras de negócio
```

---

## 🔒 Segurança

As rotas `/api/auth/**` são públicas.  
As demais exigem token JWT no header da requisição:

```http
Authorization: Bearer <seu_token>
```

---

## 🧪 Testando com Insomnia ou Postman

1. Realize um `POST` em `/api/auth/login` com email e senha válidos.
2. Copie o token JWT retornado.
3. Em outras requisições, adicione o header:

```http
Authorization: Bearer <seu_token>
```
## Link Youtube
........


## 👥 Integrantes

- Caroline de Oliveira - RM 559123
- Giulia Correa Camillo - RM 554473
- João Pedro Cancian Corrêa RM : 555341
