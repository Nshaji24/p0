package com.dealership.model;



import java.util.Scanner;



public class Car extends Object{

    String make;
    String model;
    int yearMade;
    int mileage;
    int price;
    String car_condition;

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    int car_id;
    Scanner scan = new Scanner(System.in);




    public Car(String make, String model, int yearMade, int mileage, int price, String car_condition, int car_id){
        this.make=make;
        this.model=model;
        this.yearMade=yearMade;
        this.mileage=mileage;
        this.price=price;
        this.car_condition = car_condition;
        this.car_id= car_id;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = scan.nextLine();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = scan.nextLine();
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = scan.nextInt();
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = scan.nextInt();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = scan.nextInt();
    }

    public String getCar_condition(){
        return car_condition;
    }

    public void setCar_condition(String car_condition){
        this.car_condition =scan.nextLine();
    }


    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearMade=" + yearMade +
                ", mileage=" + mileage +
                ", price=" + price +
                ", car_condition='" + car_condition + '\'' +
                ", car_id=" + car_id +
                ", scan=" + scan +
                '}';
    }
}
