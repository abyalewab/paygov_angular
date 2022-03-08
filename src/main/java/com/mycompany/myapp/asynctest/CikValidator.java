package com.mycompany.myapp.asynctest;

public class CikValidator {

    private String validCik1;
    private String validCik2;
    private String validCik3;
    private String validCik4;
    private String validCik5;

    public String getValidCik1() {
        return validCik1;
    }

    public void setValidCik1(String validCik1) {
        this.validCik1 = validCik1;
    }

    public String getValidCik2() {
        return validCik2;
    }

    public void setValidCik2(String validCik2) {
        this.validCik2 = validCik2;
    }

    public String getValidCik3() {
        return validCik3;
    }

    public void setValidCik3(String validCik3) {
        this.validCik3 = validCik3;
    }

    public String getValidCik4() {
        return validCik4;
    }

    public void setValidCik4(String validCik4) {
        this.validCik4 = validCik4;
    }

    public String getValidCik5() {
        return validCik5;
    }

    public void setValidCik5(String validCik5) {
        this.validCik5 = validCik5;
    }

    @Override
    public String toString() {
        return (
            "CikValidator {" +
            " validCik1='" +
            getValidCik1() +
            "'" +
            ", validCik2='" +
            getValidCik2() +
            "'" +
            ", validCik3='" +
            getValidCik3() +
            "'" +
            ", validCik4='" +
            getValidCik4() +
            "'" +
            ", validCik5='" +
            getValidCik5() +
            "'" +
            "}"
        );
    }
}
