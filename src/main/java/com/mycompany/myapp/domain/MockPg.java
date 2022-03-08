package com.mycompany.myapp.domain;

public class MockPg {

    String name;
    String address;
    Integer creditCardNumber;
    String expireDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Integer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public MockPg(String name, String address, Integer creditCardNumber, String expireDate) {
        super();
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.expireDate = expireDate;
    }

    public MockPg() {}
}
