package com.example.orderservice.external.decoder;

import com.example.orderservice.exception.CustomException;
import com.example.orderservice.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ErrorResponse errorResponse =  errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(),response.status());
        } catch (IOException e) {
            throw new CustomException("INTERNAL SERVER ERROR", "internal server error", 500);
        }
        return new Exception();
    }
}
