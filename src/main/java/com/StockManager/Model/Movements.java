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
@Table(name = "movements")
public class Movements implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private HandlingType type;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@CreationTimestamp
	@Column(name = "moveDate")
	private Date moveDate;

	public Movements() {
	}

	public Movements(Long id, Long productId, HandlingType type, int amount) {

		this.id = id;
		this.productId = productId;
		this.type = type;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct() {
		return productId;
	}

	public void setProduct(Long product) {
		this.productId = product;
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
		return Objects.hash(amount, id, moveDate, productId, type);
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
				&& Objects.equals(productId, other.productId) && type == other.type;
	}

}
