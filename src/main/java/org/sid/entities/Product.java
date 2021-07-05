package org.sid.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {
	
	@Id
	private String id;
	private String name;
	private Double price;
	@DBRef
	@JsonIgnore
	private Category category;

	public String toString() {
		return "{" + "id: " + id + ", name: " + name + ", price: " +price+ "}";
	}
}
