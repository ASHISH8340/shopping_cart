package com.demo.shopping.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class ErrorDetails {

    private String message;

    private int errorCode;
    private LocalDate date;

}
