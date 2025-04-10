package com.example.demo.service;

public class LoginResponse {
    private boolean success;

    public LoginResponse(boolean success, String s) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
