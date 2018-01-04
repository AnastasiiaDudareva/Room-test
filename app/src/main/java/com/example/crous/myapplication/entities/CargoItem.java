package com.example.crous.myapplication.entities;

import com.example.crous.myapplication.database.models.CarItem;
import com.example.crous.myapplication.database.models.Cargo;
import com.example.crous.myapplication.database.models.User;

public class CargoItem {
    private Cargo cargo;
    private User sender;
    private User recipient;
    private CarItem car;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public CarItem getCar() {
        return car;
    }

    public void setCar(CarItem car) {
        if (car != null) {
            this.car = car;
        }
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        if (sender != null) {
            this.sender = sender;
        }
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        if (recipient != null) {
            this.recipient = recipient;
        }
    }

    public CargoItem createTest() {
        setCargo(new Cargo().createTest());
        setSender(new User().createTest());
        setRecipient(new User().createTest());
        setCar(new CarItem().createTest());
        return this;
    }
}
