package com.example.demo.exception;
import lombok.Data;
@Data
public class ErrorResponse {
	private long currentTime;
	private int status;
	private String message;
}
