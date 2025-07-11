package com.seyitkoc.common.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {
    private Integer status;
    private Exception<E> exception;

}
