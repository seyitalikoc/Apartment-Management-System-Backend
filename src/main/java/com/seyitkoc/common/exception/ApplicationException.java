package com.seyitkoc.common.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(){}

    public ApplicationException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }

}
