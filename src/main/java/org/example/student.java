package org.example;

public class student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    int age;
    String adress;

    public student(String name, int age,  String adress) {
        this.age = age;
        this.adress = adress;
        this.name = name;
    }
}
