package com.anilkumar.bookxpertpvt;

import com.google.gson.annotations.SerializedName;

public class Pojo {
    @SerializedName("ActID")
    public int actID;
    @SerializedName("ActName")
    public String actName;
    public double amount;

    public Pojo(int actID, String actName, double amount) {
        this.actID = actID;
        this.actName = actName;
        this.amount = amount;
    }

    public int getActID() {
        return actID;
    }

    public void setActID(int actID) {
        this.actID = actID;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
