/**
 * 
 */
package neu.shoes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author TienBV
 *
 */

@Entity
@Table(name = "shoes")
public class ShoesEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "shoesName")
	private String shoesName;

	@Column(name = "image")
	private String image;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BrandShID")
	private BrandShoesEntity brandShoes;

	@Column(name = "description")
	private String description;

	@Column(name = "origin")
	private String origin;

	@Column(name = "price")
	private Integer price;

	@Column(name = "size")
	private Integer size;

	@Column(name = "color")
	private String color;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "shoesEntity",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetailEntity> orderShoes = new ArrayList<>();

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "orderDetail", joinColumns = @JoinColumn(name = "shoesID"),
	 * inverseJoinColumns = @JoinColumn(name = "orderID")) private List<OrderEntity>
	 * order = new ArrayList<>();
	 */

	public String getShoesName() {
		return shoesName;
	}

	public void setShoesName(String shoesName) {
		this.shoesName = shoesName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BrandShoesEntity getBrandShoes() {
		return brandShoes;
	}

	public void setBrandShoes(BrandShoesEntity brandShoes) {
		this.brandShoes = brandShoes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetailEntity> getOrderShoes() {
		return orderShoes;
	}

	public void setOrderShoes(List<OrderDetailEntity> orderShoes) {
		this.orderShoes = orderShoes;
	}

}
