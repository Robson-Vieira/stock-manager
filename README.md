# 📦 StockManager API  

🚧 **Status do Projeto**: Em desenvolvimento (não está pronto para produção)  
*Esta API está em fase de construção e pode sofrer alterações significativas.*  

---

## 🔄 Funcionalidades  

### **1. CRUD de Produtos** (`/productId`)  
| Método HTTP | Endpoint             | Descrição                          |  
|-------------|----------------------|------------------------------------|  
| `GET`       | `/productId/{id}`      | Busca um produto por ID.           |  
| `GET`       | `/productId`           | Lista **todos** os produtos.       |  
| `POST`      | `/productId`           | Cria um novo produto.              |  
| `PUT`       | `/productId`           | Atualiza um produto existente.     |  
| `DELETE`    | `/productId/{id}`      | Remove um produto por ID.          |  

### **2. CRUD de Movimentações** (`/moviments`)  
| Método HTTP | Endpoint               | Descrição                          |  
|-------------|------------------------|------------------------------------|  
| `GET`       | `/moviments`           | Lista **todas** as movimentações.  |  
| `GET`       | `/moviments/{id}`      | Busca uma movimentação por ID.     |  
| `POST`      | `/moviments`           | Cria uma nova movimentação.        |  
| `PUT`       | `/moviments`           | Atualiza uma movimentação.         |  
| `DELETE`    | `/moviments/{id}`      | Remove uma movimentação por ID.    |  

---

## ⚠️ Observações  
- Os endpoints podem ser ajustados durante o desenvolvimento.  
- A documentação será expandida conforme a API evolui.  

---

## 🛠️ Tecnologias Utilizadas  
- **Spring Boot** (Java)  
- **Spring Web** (REST API)  
- **Hibernate/JPA** (Persistência)  

---

🔹 **Contribuições são bem-vindas!** Se encontrar bugs ou tiver sugestões, abra uma *issue*.