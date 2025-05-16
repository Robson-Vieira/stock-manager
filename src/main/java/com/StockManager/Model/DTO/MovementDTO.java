package com.StockManager.Model.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.StockManager.Model.HandlingType;


public class MovementDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long productId;
	private HandlingType type;
	private int amount;
	private Date moveDate;

		public MovementDTO(Long id, Long productId, HandlingType type, int amount, Date moveDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.type = type;
		this.amount = amount;
		this.moveDate = moveDate;
	}

	public MovementDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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
		MovementDTO other = (MovementDTO) obj;
		return amount == other.amount && Objects.equals(id, other.id) && Objects.equals(moveDate, other.moveDate)
				&& Objects.equals(productId, other.productId) && type == other.type;
	}

}
