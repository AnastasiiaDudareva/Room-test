package com.example.crous.myapplication.entities;

public enum UserRole {
    USER("user"),       //обычный юзер, который использует приложение и может заказать доставку товара
    CLIENT("client"),   // платит за доставку своих товаров (например магазин какой-то) Компания, которая пользуется услугами
    ADMIN("admin"),
    DRIVER("driver");

    String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getName() {
        return roleName;
    }

    public static UserRole getRole(String roleName) {
        switch (roleName) {
            case "admin":
                return ADMIN;
            case "client":
                return CLIENT;
            case "driver":
                return DRIVER;
            default:
                return USER;

        }
    }

}
