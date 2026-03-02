package com.dev.kevin.aisimulator.model;

public class ChatMessage {

	private MessageSender sender;
	private String content;
	
	public ChatMessage(MessageSender sender, String content) {
		this.sender = sender;
		this.content = content;
	}

	public MessageSender getSender() {
		return sender;
	}

	public String getContent() {
		return content;
	}
	
	
	
}
