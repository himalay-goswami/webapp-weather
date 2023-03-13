package com.himalaya.entity.notification;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Greeting {

	//this class acts as message model for notifications.
	private String message;

	public Greeting(String message) {
		this.message = message;
	}
}
