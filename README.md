# 📦 StockManager API  

🚧 **Status do Projeto**: Em desenvolvimento (não está pronto para produção)  
*Esta API está em fase de construção e pode sofrer alterações significativas.*  

---

## 🔄 Funcionalidades  

### **1. CRUD de Produtos** (`/product`)  
| Método HTTP | Endpoint             | Descrição                          |  
|-------------|----------------------|------------------------------------|  
| `GET`       | `/product/{id}`      | Busca um produto por ID.           |  
| `GET`       | `/product`           | Lista **todos** os produtos.       |  
| `POST`      | `/product`           | Cria um novo produto.              |  
| `PUT`       | `/product`           | Atualiza um produto existente.     |  
| `DELETE`    | `/product/{id}`      | Remove um produto por ID.          |  

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