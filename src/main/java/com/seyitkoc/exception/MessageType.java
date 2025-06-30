package com.seyitkoc.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    EMAIL_EXISTS("1001","Email already exists"),
    INVALID_CREDENTIALS("1002", "Invalid credentials"),
    AUTH_SAVE_FAILED("1003", "Auth save failed"),
    TOKEN_MISSING("1004", "Token is missing"),
    TOKEN_EXPIRED("1005", "Token is expired"),
    USER_NOT_FOUND("1006", "User not found"),
    INTERNAL_SERVER_ERROR("1007", "Internal server error"),
    USER_SAVE_FAILED("1008", "User save failed"),
    UNAUTHORIZED("1009", "Unauthorized access"),
    NOT_FOUND("1010", "Resource not found"),
    BAD_REQUEST("1011", "Bad request"),
    ERROR("1012", "An error occurred"),;
    private final String code;

    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
