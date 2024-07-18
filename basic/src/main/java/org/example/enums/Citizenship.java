package org.example.enums;

public enum Citizenship {
    ENGLAND("Англия"),
    FRANCE("Франция"),
    PORTUGAL("Португалия"),
    SPAIN("Испания"),
    DENMARK("Дания");

    private final String citizenshipName;

    private Citizenship(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public static Citizenship  fromString(String value) {
        if (value != null) {
            for (Citizenship citizenship : Citizenship.values()) {
                if (value.equalsIgnoreCase(citizenship.citizenshipName)) {
                    return citizenship;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }
}
