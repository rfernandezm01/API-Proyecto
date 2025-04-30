package com.example.demo.service;

public class RegisterResponse {
    private boolean success;

    public RegisterResponse(boolean success, String s) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
