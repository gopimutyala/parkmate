package com.mouritech.parkmate.exception;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ErrorResponse {

	private String message;
    private String details;
    private LocalDateTime timestamp;

}
