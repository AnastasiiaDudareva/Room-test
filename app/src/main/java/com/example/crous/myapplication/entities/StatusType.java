package com.example.crous.myapplication.entities;

public enum StatusType {
    NEW("new"),
    SCHEDULED("scheduled"),
    IN_ROUTE("inroute"),
    DONE("done"),
    CHANGED("changed"),
    NEED_APPROVAL("need_approval");

    String name;

    StatusType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static StatusType getType(String status) {
        switch (status) {
            case "scheduled":
                return SCHEDULED;
            case "inroute":
                return IN_ROUTE;
            case "done":
                return DONE;
            case "changed":
                return CHANGED;
            case "need_approval":
                return NEED_APPROVAL;
            default:
                return NEW;

        }
    }
}
