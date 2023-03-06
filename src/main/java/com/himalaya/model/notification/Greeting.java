package com.himalaya.model.notification;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Greeting {

	private String message;

	private List<Integer> myNumbers = new ArrayList<>();
	
	 public Greeting(String message) { 
		 this.message = message; 
	 }
}
