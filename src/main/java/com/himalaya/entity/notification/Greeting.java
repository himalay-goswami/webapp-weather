package com.himalaya.entity.notification;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Greeting {
	private String message;

	public Greeting(String message) {
		this.message = message;
	}
}
