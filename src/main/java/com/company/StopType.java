package com.company;

public enum StopType {
    UNKNOWN("неизвестно"),

    TRANSIT("остановка"),
    TRANSFER("пересадка");

    private final String name;

    StopType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static StopType getByName(String name) {
        StopType[] stopTypes = values();
        for (int i = 1; i < values().length; i++)
            if (stopTypes[i].name.equalsIgnoreCase(name)) return stopTypes[i];

        return UNKNOWN;
    }
}
