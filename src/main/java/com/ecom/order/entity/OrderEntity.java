package com.ecom.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ecom_orders")
public class OrderEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", initialValue = 1, allocationSize = 1, sequenceName = "id_seq")
	private long id;
	
	@Column(name = "order_name")
	private String orderName;
	
	@Column(name = "order_price")
	private long orderPrice;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "total")
	private long total;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "photo")
	@Lob
	private byte[] billPhoto;
	
	@Column(name = "bii_pdf")
	@Lob
	private byte [] billPdf;
	
	@CreationTimestamp
	@Column(name = "createdat")
	private Date createdAt = new Date();

	
	
}
