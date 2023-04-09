package org.retailfeeds.web.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stores")
//@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
public class Store {

	@Id
	private String id;
	
	@Column(nullable = false,name = "`sku`")
	private long sku;
	
	@Column(nullable = false,name = "`productName`")
	private String productName;
	
	@Column(nullable = false,name = "`price`")
	private double price;
	
	@Column(nullable = false,name = "`mdate`")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date mdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
}
