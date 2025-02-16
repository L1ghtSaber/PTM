package com.company;

public enum TransportType {
    UNKNOWN("неизвестно"),

    AIR("авиа"),
    RAILWAY("ж/д"),
    BUS("автобус"),
    MIX("микс");

    private final String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TransportType getByName(String name) {
        TransportType[] transportTypes = values();
        for (int i = 1; i < values().length; i++)
            if (transportTypes[i].name.equalsIgnoreCase(name)) return transportTypes[i];

        return UNKNOWN;
    }
}