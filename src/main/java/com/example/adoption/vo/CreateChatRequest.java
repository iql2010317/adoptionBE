package com.example.adoption.vo;

public class CreateChatRequest {

	
	/* parameters */
	private int creator;
	
	private String subscriberList;
	
	private String name;

	
	
	
	/* constructors */
	public CreateChatRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateChatRequest(int creator, String subscriberList, String name) {
		super();
		this.creator = creator;
		this.subscriberList = subscriberList;
		this.name = name;
	}
	
	
	
	/* getter&setter */
	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getSubscriberList() {
		return subscriberList;
	}

	public void setSubscriberList(String subscriberList) {
		this.subscriberList = subscriberList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
