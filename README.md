# 🚀 Web Service Project - Spring Boot + JPA

Um projeto completo de API REST desenvolvido com Spring Boot para fins de estudo, demonstrando as melhores práticas de desenvolvimento de aplicações web modernas.

## 📋 Sobre o Projeto

Este projeto é uma aplicação de e-commerce simplificada que implementa operações CRUD para gerenciamento de usuários, pedidos, produtos e categorias. Foi desenvolvido como material de estudo para aprender e praticar conceitos avançados de desenvolvimento backend com Java e Spring Boot.

## ✨ Características Principais

- 🗄️ **Banco de dados embarcado H2** - Zero configuração necessária
- 🚀 **Autoexecutável** - Basta rodar e usar!
- 📚 **Projeto educacional** - Focado em aprendizado
- 🏗️ **Arquitetura RESTful** - API seguindo melhores práticas
- 🔗 **Relacionamentos complexos** - Many-to-many, One-to-many, Many-to-one

## 🛠️ Stack Tecnológica

- **Java 25** - Linguagem principal
- **Spring Boot 4.0.4** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web MVC** - API REST
- **H2 Database** - Banco de dados em memória
- **PostgreSQL** - Banco de dados relacional (opcional)
- **Maven** - Gerenciamento de dependências
- **Spring Boot DevTools** - Ferramentas de desenvolvimento
- **Jakarta Persistence** - Mapeamento objeto-relacional

## 🏛️ Arquitetura do Projeto

```
src/main/java/com/samuelbraga/webserviceproject/
├── config/          # Configurações e beans
├── controllers/     # Endpoints REST (Resources)
├── entities/        # Entidades JPA
├── enums/          # Enumerações do sistema
├── repositories/   # Interfaces Spring Data JPA
├── services/       # Camada de negócio
└── resources/      # Controladores REST
```

## 📊 Entidades do Sistema

- **User** - Usuários do sistema
- **Order** - Pedidos com status dinâmico
- **Product** - Produtos com múltiplas categorias
- **Category** - Categorias organizacionais

## 🚀 Como Executar

### Pré-requisitos
- Java 25 ou superior
- Maven 3.6+

### Execução
```bash
# Clone o repositório
git clone <repository-url>
cd webserviceproject

# Execute a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

### Console H2
Acesse o console do banco de dados H2 em:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (em branco)

## 📡 Endpoints da API

### Categories
- `GET /categories` - Listar todas as categorias
- `GET /categories/{id}` - Buscar categoria por ID

### Products  
- `GET /products` - Listar todos os produtos
- `GET /products/{id}` - Buscar produto por ID

### Users
- `GET /users` - Listar todos os usuários
- `GET /users/{id}` - Buscar usuário por ID

### Orders
- `GET /orders` - Listar todos os pedidos
- `GET /orders/{id}` - Buscar pedido por ID

## 🎯 Objetivos de Aprendizado

Este projeto foi desenvolvido para praticar:

- ✅ Desenvolvimento de APIs RESTful
- ✅ Mapeamento objeto-relacional com JPA
- ✅ Relacionamentos entre entidades
- ✅ Injeção de dependências com Spring
- ✅ Padrão Repository/Service/Controller
- ✅ Configuração de banco de dados embarcado
- ✅ Enums personalizados com métodos
- ✅ Boas práticas de código Java

## 🔧 Configurações

O projeto utiliza configuração automática do Spring Boot com:
- **H2 Database** - Configurado para rodar em memória
- **Porta 8080** - Servidor embutido Tomcat
- **Dados de teste** - Populados automaticamente na inicialização

## 📝 Notas

- Este é um projeto **puramente educacional**
- Focado em demonstrar conceitos de Spring Boot
- Não implementa autenticação ou validações complexas
- Ideal para estudantes iniciantes com Spring Boot

## 🤝 Contribuições

Este projeto é um material de estudo. Sinta-se à vontade para usar, modificar e aprender com ele!

---

**Desenvolvido com ❤️ para fins educacionais**
