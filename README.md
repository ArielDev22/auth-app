# Aplicação de Autenticação de Usuários

## Índice
- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Endpoints](#endpoints)
- [Como usar](#como-usar)
- [Corpo das Requisições e Respostas](#corpo-das-requisições-e-respostas)
- [Clonar o repositório](#clonar-o-repositório)
- [Contato](#contato)

## Descrição
> Aplicação que realiza a autenticação de usuários que estão devidamente cadastrados no sistema. Gerencia os envios de requisições com base nas roles de cada usuário.

## Funcionalidades
- Cadastro de novos usuários
- Login
- Geração e validação de tokens
- Tratamento de exceções
- Permissões por roles (user/admin)

## Endpoints
- **POST /auth/register**: Cadastro de novo usuário
- **POST /auth/login**: Login de usuário
- **GET /users/info/{id}**: acessar dados de um usuário
- **DELETE /users/delete/{id}**: deletar dados de um usuário (Admin)

## Como usar
- **Execute a aplicação**:
  - ```bash
    mvn spring-boot:run
- **Importar as requests**:
  - Importe o arquivo **auth.postman_collection.json** no Postman
## Corpo das Requisições e Respostas

### 1. Cadastrar Usuário

**Método:** `POST /auth/register`

#### Corpo da Requisição
```json
{
    "name": "João",
    "email": "joao@gmail.com",
    "password": "1234",
    "role": "admin"
}
```
#### Resposta de Sucesso (200)
```http
status OK
```
#### Resposta de Erro (400)
```json
{
  "status": "BAD_REQUEST",
  "message": "An account with this email already exists"
}
```
### 2. Login de Usuário
**Método:** `POST /auth/login`

#### Corpo da Requisição
```json
{
    "email": "joao@gmail.com",
    "password": "1234"
}
```
#### Resposta de Sucesso (200)
```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwcCIsInN1YiI6ImpvYW9AZ21haWwuY29tIiwiZXhwIjoxNzI3NzExOTY1fQ.2loh5ixDAp36B1rREAD_8GoQ8RZ4W-IsGYKRxJdlY0U"
}
```
#### Resposta de Erro (400)
```json
{
  "status": "NOT_FOUND",
  "message": "An account with this email doesn't exist"
}
```
#### Resposta de Erro (400)
```json
{
  "status": "BAD_REQUEST",
  "message": "incorrect password"
}
```

### 3. Acessar dados de usuário

**Método:** `GET /users/info/{id}`

#### Cabeçalho (Headers)
```http
Authorization: Bearer {seu token}
```
#### Resposta de Sucesso (200)
```json
{
  "name": "João",
  "email": "joao@gmail.com",
  "role": "admin"
}
```

### 4. Deletar um usuário

**Método:** `DELETE /users/delete/{id}`

#### Cabeçalho (Headers)
```http
Authorization: Bearer {seu token de admin}
```
#### Resposta de Sucesso (200)
```http
status OK
```
#### Resposta de Sucesso (403)
```http
status Forbidden
```

## Clonar o repositório
- **SSH**: git clone git@github.com:ArielDev22/auth-app.git
- **HTTPS**: git clone https://github.com/ArielDev22/auth-app.git

## Contato
- **Email**: ariel.dev22@gmail.com
- **Link do projeto**: https://github.com/ArielDev22/auth-app
