package com.upc.edu.pe.petcare.util;

public enum ExceptionMessageEnum {
    MODEL_NOT_FOUND("recurso no encontrado"),
    INCORRECT_REQUEST("Petición incorrecta");

    private final String value;

    ExceptionMessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
