package de.cruisecontrol.cardata;

import java.util.Date;

import de.cruisecontrol.util.Util;

/**
 * Created by Admin on 02.10.2015.
 */
public class Refuel {
    private String id;
    private float amount;
    private Date date;
    private int mileage;
    private float pricePerUnit = -1;
    private String comment;

    public Refuel(String id, float amount, int mileage, String comment){
        this.id = id;
        this.amount = amount;
        this.mileage = mileage;
        this.comment = comment;
    }

    /**
     * Generates string for output file.
     * @return
     */
    public String toOutputString(){
        StringBuilder result = new StringBuilder();
        return result.toString();
    }

    // ***************
    // GETTER & SETTER
    // ***************
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public float getPricePerUnit() {
        return pricePerUnit;
    }
    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
