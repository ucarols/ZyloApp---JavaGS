# ZyloApp - Backend Java 


API REST desenvolvida em Java com Spring Boot, autenticação JWT, integração com dados climáticos e documentação via Swagger/OpenAPI.

---

## 🔧 Tecnologias Utilizadas

- ☕ Java 17+
- 🚀 Spring Boot
- 🌐 Spring Web
- 🗃️ Spring Data JPA
- 🔒 Spring Security (JWT)
- ✅ Bean Validation
- 📘 Swagger/OpenAPI 3
- 🧬 Lombok
- 🛢️ Banco de Dados Oracle
- 📦 Maven

---

## 🔐 Funcionalidades

- Registro de usuários com validação
- Login com JWT
- Listagem, edição e remoção de usuários
- Recebimento de dados climáticos da aplicação mobile
- Integração com front-end via token JWT
- Swagger para documentação interativa

---

## 🚀 Como Executar Localmente

### 1. Clone o repositório

```bash
git clone https://github.com/ucarols/ZyloApp---JavaGS.git
cd ZyloApp---JavaGS
```

### 2. Configure o banco de dados Oracle

Edite o arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=rm559123
spring.datasource.password=fiap

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

### 3. Compile e execute o projeto

```bash
./mvnw spring-boot:run
```

---

## 🔑 Principais Endpoints

### 🔐 Autenticação

| Método | Rota               | Descrição                |
|--------|--------------------|--------------------------|
| POST   | `/api/auth/register` | Cadastro de novo usuário |
| POST   | `/api/auth/login`    | Login com retorno do JWT |

### 👤 Usuários

| Método | Rota                | Descrição                  |
|--------|---------------------|----------------------------|
| GET    | `/api/usuarios`       | Listagem com paginação     |
| GET    | `/api/usuarios/{id}`  | Buscar por ID              |
| PUT    | `/api/usuarios/{id}`  | Atualizar dados do usuário |
| DELETE | `/api/usuarios/{id}`  | Remover usuário            |

### 🌦️ Clima

| Método | Rota         | Descrição                        |
|--------|--------------|----------------------------------|
| POST   | `/api/clima` | Receber dados do app sobre clima |

---

## 📑 Swagger

📚 Acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

---

## 📂 Estrutura do Projeto

```
com.zyloapp
├── config         # Swagger e configs extras
├── controller     # Endpoints REST
├── dto            # Objetos de transporte de dados
├── model          # Entidades JPA
├── repository     # Camada de acesso a dados
├── security       # JWT, filtros, configurações
├── service        # Regras de negócio
├── util           # Utilitários gerais
├── exceptions     # Tratamento de erros
```

---

## 🔒 Segurança JWT

As rotas públicas são:

- `/api/auth/**`

Todas as demais exigem o token JWT:

```http
Authorization: Bearer <seu_token>
```

---

## 🧪 Testando com Insomnia/Postman

1. Faça login (`POST /api/auth/login`)
2. Copie o token JWT retornado
3. Em outras requisições, envie no header:

```http
Authorization: Bearer <seu_token>
```

---

## 📽️ Demonstração

📺 Link para o vídeo no YouTube:  
**[Video](https://www.youtube.com/watch?v=t5PT38Et8dI)**

---

## 👥 Integrantes

- 👩‍💻 Caroline de Oliveira - RM 559123
- 👩‍💻 Giulia Correa Camillo - RM 554473
- 👨‍💻 João Pedro Cancian Corrêa - RM 555341

---

