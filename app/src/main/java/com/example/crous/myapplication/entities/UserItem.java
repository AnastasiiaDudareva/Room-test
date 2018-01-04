package com.example.crous.myapplication.entities;


import com.example.crous.myapplication.database.models.CarItem;
import com.example.crous.myapplication.database.models.CompanyItem;
import com.example.crous.myapplication.database.models.User;

public class UserItem {
    public User user = new User();
    private CarItem car;
    private CompanyItem company;

    public CarItem getCar() {
        return car;
    }

    public void setCar(CarItem car) {
        if (user.role == UserRole.DRIVER) {
            this.car = car;
        }
    }

    public CompanyItem getCompany() {
        return company;
    }

    public void setCompany(CompanyItem company) {
        if (user.role == UserRole.CLIENT) {
            this.company = company;
        }
    }

    public UserItem createTest() {
        user.userId="2";
        user.email = "test@test.com";
        user.phone = "80987654321";
        user.role = UserRole.CLIENT;
        user.name = "Name";
        user.surname = "Surname";
        user.icon = "icon";
        user.address = "address, 1";
        setCompany(new CompanyItem().createTest());
        setCar(new CarItem().createTest());
        return this;
    }

    @Override
    public String toString() {
        return "UserItem{" +
                "user=" + user +
                ", car=" + car +
                ", company=" + company +
                '}';
    }
}
