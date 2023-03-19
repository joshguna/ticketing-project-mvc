package com.joshguna.enums;

public enum Gender {

    Male("Male"), FEMALE("Female");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
