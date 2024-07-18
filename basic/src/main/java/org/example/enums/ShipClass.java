package org.example.enums;

public enum ShipClass {
    BRIG("Бриг"),
    BRIGANTINE("Бригантина"),
    SCHOONER("Шхуна"),
    GALLEY("Галера"),
    GALLEON("Галеон"),
    CARAVEL("Каравелла"),
    FRIGATE("Фрегат");


    private final String className;

    private ShipClass(String className) {
        this.className = className;
    }

    public static ShipClass  fromString(String value) {
        if (value != null) {
            for (ShipClass shipClass : ShipClass.values()) {
                if (value.equalsIgnoreCase(shipClass.className)) {
                    return shipClass;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }

    public String getClassName() {
        return className;
    }
}
