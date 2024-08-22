package com.example.labprog.fatorial.controllers;

import com.example.labprog.fatorial.entities.FatorialEntity;

public class ApiResponse {

    String message;
    FatorialEntity fatorialEntity;
    
    public ApiResponse(String message, FatorialEntity fatorialEntity) {
        this.message = message;
        this.fatorialEntity = fatorialEntity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FatorialEntity getFatorialEntity() {
        return fatorialEntity;
    }

    public void setFatorialEntity(FatorialEntity fatorialEntity) {
        this.fatorialEntity = fatorialEntity;
    }

}
