# 📦 Stock Manager API - Documentação

## 📌 Visão Geral
API RESTful para gerenciamento de estoque com:

- CRUD completo de produtos
- CRUD de movimentações (entradas/saídas) com controle de estoque automático
- Validações de negócio (como estoque insuficiente)

## 🌟 Endpoints Principais

### 🛍️ Produtos (`/product`)

| Método | Endpoint           | Descrição               | Status |
|--------|--------------------|-------------------------|--------|
| GET    | `/product`         | Lista todos os produtos | ✅     |
| GET    | `/product/{id}`    | Busca produto por ID    | ✅     |
| POST   | `/product`         | Cria novo produto       | ✅     |
| PUT    | `/product`         | Atualiza produto existente | ✅ |
| DELETE | `/product/{id}`    | Remove produto          | ✅     |

### 📦 Movimentações (`/moviments`)

| Método | Endpoint            | Descrição                     | Status |
|--------|---------------------|-------------------------------|--------|
| GET    | `/moviments`        | Lista todas movimentações     | ✅     |
| GET    | `/moviments/{id}`   | Busca movimentação por ID     | ✅     |
| POST   | `/moviments`        | Registra nova movimentação    | ✅     |
| DELETE | `/moviments/{id}`   | Remove movimentação           | ✅     |

**Observação:** A atualização (PUT) de movimentações está temporariamente desabilitada por decisão de design

## 🛠️ Como Usar

### 🔄 Produtos

**Criar Produto (POST)**
```json
{
  "name": "Notebook Dell",
  "description": "Notebook i7 16GB RAM",
  "amount": 10,
  "heritage": 123456
}
```

**Atualizar Produto (PUT)**
```json
{
  "id": 1,
  "name": "Notebook Dell Updated",
  "description": "Notebook i7 32GB RAM",
  "amount": 15,
  "heritage": 123456
}
```

### 🔄 Movimentações

**Registrar Entrada (POST)**
```json
{
  "productId": 1,
  "type": "INPUT",
  "amount": 5
}
```

**Registrar Saída (POST)**
```json
{
  "productId": 1,
  "type": "OUTPUT",
  "amount": 3
}
```
O sistema automaticamente ajusta o estoque do produto relacionado.

---

## ⚠️ Regras de Negócio

- **Estoque mínimo:** Não permite saída maior que a quantidade disponível
  - Erro: `InsufficientQuantityException` (HTTP 400)
- **Produto não encontrado:**
  - Erro: `ProdutNotFoudException` (HTTP 404)
- **Movimentação não encontrada:**
  - Erro: `MovementNotFound` (HTTP 404)
- **Nomes únicos:** Não permite produtos com nomes duplicados

---

## 🏗️ Estrutura do Projeto

```
📦 StockManager
├── 📂 Model
│   ├── Product.java          # Entidade Produto
│   ├── Movements.java        # Entidade Movimentação
│   ├── HandlingType.java     # Enum (INPUT/OUTPUT)
│   └── 📂 DTO
│       ├── ProductDTO.java    # DTO para Produto
│       └── MovementDTO.java   # DTO para Movimentação
├── 📂 Controller             # Endpoints REST
├── 📂 Services               # Lógica de negócio
├── 📂 Repositories           # Comunicação com banco
├── 📂 Config                 # Configurações
└── 📂 Exceptions             # Exceções customizadas
```

---

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.x
- JPA/Hibernate
- MySQL
- Flyway (migrações de banco)
- ModelMapper (conversão DTO/Entity)

---

## 💡 Considerações sobre Atualização de Movimentações

A atualização de movimentações foi temporariamente desabilitada devido à complexidade envolvida:

- **Impacto no estoque:** Alterar uma movimentação existente exigiria:
  - Reverter o impacto original no estoque
  - Aplicar o novo valor
  - Tratar concorrência e transações atômicas
- **Integridade histórica:** Movimentações geralmente são registros imutáveis por natureza contábil

---

## ▶️ Como Executar

1. Configure o MySQL no `application.properties`
2. Execute as migrações do Flyway
3. Inicie a aplicação Spring Boot
4. Acesse via [http://localhost:8080](http://localhost:8080)

---

## 📚 Melhorias Futuras

- Implementar autenticação/autorização
- Adicionar relatórios de estoque
- Criar endpoints para consultas complexas
- Implementar sistema de categorias de produtos
- Adicionar documentação Swagger/OpenAPI
