package com.example.labprog.users;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// Anotação para especificar a ordem das propriedades no JSON de saída
@JsonPropertyOrder({ "message", "data" })
public class ApiResponse<T> {
    private String message; // Novo campo para a mensagem
    private T data;

    // Construtor
    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    // Getter para a mensagem
    public String getMessage() {
        return message;
    }

    // Setter para a mensagem
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter para os dados
    public T getData() {
        return data;
    }

    // Setter para os dados
    public void setData(T data) {
        this.data = data;
    }
}
