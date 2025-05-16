-- Tabela de Produtos
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    amount INT NOT NULL DEFAULT 0,
    heritage BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Movimentações
CREATE TABLE movements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    type VARCHAR(10) NOT NULL, -- INPUT ou OUTPUT
    amount INT NOT NULL,
    move_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_movement_product FOREIGN KEY (product_id) REFERENCES products(id)
);
