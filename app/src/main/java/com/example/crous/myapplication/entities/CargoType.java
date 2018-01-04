package com.example.crous.myapplication.entities;

public enum CargoType {
    STANDARD("standart"),
    EXPRESS("express");

    String name;

    CargoType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CargoType getType(String status) {
        switch (status) {
            case "express":
                return EXPRESS;
            default:
                return STANDARD;

        }
    }
}
