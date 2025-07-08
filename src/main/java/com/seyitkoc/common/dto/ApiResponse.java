package com.seyitkoc.common.dto;

import com.seyitkoc.common.handler.ApiError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse<T> {
    private boolean result;
    private ApiError<?> errorMessage;
    private T data;

    public static <T> ApiResponse<T> ok(T data){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResult(true);
        apiResponse.setData(data);
        apiResponse.setErrorMessage(null);
        return apiResponse;
    }

    public static <T> ApiResponse<T> error(ApiError<?> errorMessage){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResult(false);
        apiResponse.setData(null);
        apiResponse.setErrorMessage(errorMessage);
        return apiResponse;
    }
}
