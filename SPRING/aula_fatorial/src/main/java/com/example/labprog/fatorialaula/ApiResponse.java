package com.example.labprog.fatorialaula;

import com.example.labprog.fatorialaula.entities.FatorialEntity;

public class ApiResponse {

    String message;
    FatorialEntity fatorialEntity;

    

    public ApiResponse() {
    }
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
