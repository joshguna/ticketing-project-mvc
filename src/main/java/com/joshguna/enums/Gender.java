package com.joshguna.enums;

public enum Gender {

    MALE("Male"), FEMALE("Female");

    public final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
