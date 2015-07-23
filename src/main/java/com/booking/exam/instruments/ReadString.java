package com.booking.exam.instruments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ReadString {

	private String userLoginEmail;
	private String password;
	private String firstName;
	private String lastName;

	// our constructor
	public ReadString (String pathToFileWithCredentials) {
		String[] parts = readFile(pathToFileWithCredentials).split(",");
		userLoginEmail = parts[0];
		password = parts[1];
		firstName = parts[2];
		lastName = parts[3];
		
		//verify reading parameters
		
		System.out.println(userLoginEmail);
		System.out.println(password);
		System.out.println(firstName);
		System.out.println(lastName);
	}

	public String readFile(String filepath) {
		File f = new File(filepath);
		try {
			byte[] bytes = Files.readAllBytes(f.toPath());
			return new String(bytes, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	} 
	

	public String getUserName() {
		return userLoginEmail;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
} 
