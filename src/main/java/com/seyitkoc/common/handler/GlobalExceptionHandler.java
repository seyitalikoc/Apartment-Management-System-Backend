package com.seyitkoc.common.handler;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<ApiResponse<Void>> handleApplicationException(ApplicationException exception, WebRequest request) throws UnknownHostException {
        ApiResponse<Void> rootEntity = ApiResponse.error(createApiError(exception.getMessage(),request));

        return ResponseEntity.badRequest().body(rootEntity);
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request) throws UnknownHostException {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(LocalDateTime.now());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);

        apiError.setException(exception);

        return apiError;
    }

    private String getHostName() throws UnknownHostException {
        try{
            return InetAddress.getLocalHost().getHostName();
        } catch (RuntimeException e) {
            System.out.println("Error while getting hostname: " + e.getMessage());
        }
        return "";
    }

}
