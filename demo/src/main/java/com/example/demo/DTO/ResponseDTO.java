package com.example.demo.DTO;

public class ResponseDTO {
    private String message;
    private String status;

    public ResponseDTO(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
