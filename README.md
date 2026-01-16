# 🎯 Demo DAO JDBC

Projeto desenvolvido como parte do curso **Java Completo: Programação Orientada a Objetos + Projetos** do professor **Nélio Alves (Udemy)**.

Este módulo aborda **acesso a banco de dados com JDBC**, aplicando conceitos de **DAO (Data Access Object)**, **Factory**, e boas práticas de programação orientada a objetos.

---

## 🔷 Objetivo do Projeto

- Demonstrar como realizar operações básicas de persistência em banco de dados utilizando JDBC.
- Implementar o padrão DAO para separar a lógica de acesso a dados da lógica de negócio.
- Exercitar conceitos de interfaces, abstração e encapsulamento em Java.
- Criar um projeto didático que simula operações de CRUD em entidades como `Seller` e `Department`.

---

## ⚙️ Tecnologias Utilizadas

- ☕ Java 17+
- 🔌 JDBC (Java Database Connectivity)
- 🐬 MySQL (banco de dados relacional)
- 🧩 DAO Pattern (Data Access Object)
- 🏭 Factory Pattern para criação dos DAOs
- 🛠️ Maven / IntelliJ IDEA para gerenciamento do projeto

---

## 📁 Estrutura do Projeto

```
src/
 └── application/
     └── Program.java        # Classe principal para testes
 └── model/
     └── dao/                # Interfaces DAO
     └── dao/impl/           # Implementações JDBC dos DAOs
     └── entities/           # Classes de domínio (Seller, Department)
 └── db/
     └── DB.java             # Conexão e utilitários JDBC
db.properties                # Configuração de conexão com o banco
```

---

## 🚀 Como Executar

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/giuliano6943/demo-dao-jdbc.git
   ```

2. **Configurar o banco de dados MySQL**
   - Criar o banco `coursejdbc`.
   - Executar os scripts SQL para criar as tabelas `seller` e `department`.
   - Editar o arquivo `db.properties` com suas credenciais:
     ```properties
     user=root
     password=123456
     dburl=jdbc:mysql://localhost:3306/coursejdbc
     ```

3. **Executar o projeto**
   - Rodar a classe `Program` ou `Program2` para testar os métodos DAO.

---

## 🧪 Funcionalidades Implementadas

### DepartmentDao
- `insert(Department obj)`
- `update(Department obj)`
- `deleteById(Integer id)`
- `findById(Integer id)`
- `findAll()`

### SellerDao
- CRUD completo com relacionamento ao `Department`

---

## 📚 Contexto Didático

Este projeto faz parte do módulo de **acesso a banco de dados** do curso do Nélio Alves, considerado um dos mais completos de Java e OO.  
O curso cobre:

- Java e OO avançado  
- UML  
- JDBC  
- JavaFX  
- Spring Boot  
- JPA / Hibernate  
- MySQL  
- MongoDB  
- E muito mais!

---

## 🙌 Créditos

- 🎓 Curso: [Java COMPLETO: Programação Orientada a Objetos + Projetos](https://www.udemy.com/course/java-curso-completo/) - Nélio Alves (Udemy)
- 👨‍💻 Autor do projeto: **Giuliano**
- 👨‍🏫 Professor: **Nélio Alves**
