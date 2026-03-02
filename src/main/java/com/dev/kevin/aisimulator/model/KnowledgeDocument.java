package com.dev.kevin.aisimulator.model;

public class KnowledgeDocument {

	private String productName;
	
	private String category;
	
	private String content;
	
	public KnowledgeDocument(String productName, String category, String content) {
		this.productName = productName;
		this.category = category;
		this.content= content; 
	}

	public String getProductName() {
		return productName;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}
	
	
}
