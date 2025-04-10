package com.StockManager.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movimentações")
public class Movements implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Product product;
	
	@Column(name = "movimentação")
	@Enumerated(EnumType.STRING)
	private HandlingType type;
	
	@Column(name = "quantidade", nullable = false)
	private int amount;
	
	@CreationTimestamp
	@Column(name = "criação")
	private Date moveDate;

	public Movements(Long id2, Product product2, String string, int i, Date date) {
	}

	public Movements(Long id, Product product, HandlingType type, int amount, Date moveDate) {

		this.id = id;
		this.product = product;
		this.type = type;
		this.amount = amount;
		this.moveDate = moveDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public HandlingType getType() {
		return type;
	}

	public void setType(HandlingType type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getMoveDate() {
		return moveDate;
	}

	public void setMoveDate(Date moveDate) {
		this.moveDate = moveDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, moveDate, product, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movements other = (Movements) obj;
		return amount == other.amount && Objects.equals(id, other.id) && Objects.equals(moveDate, other.moveDate)
				&& Objects.equals(product, other.product) && type == other.type;
	}

}
