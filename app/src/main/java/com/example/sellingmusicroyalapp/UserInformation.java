package com.example.sellingmusicroyalapp;

public class UserInformation {
    public String userName;
    public String userPhone;
    public String userAddress;
    public String userDOB;

    public UserInformation() {
    }

    public UserInformation(String userName, String userPhone, String userAddress, String userDOB) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userDOB = userDOB;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(String userDOB) {
        this.userDOB = userDOB;
    }
}
