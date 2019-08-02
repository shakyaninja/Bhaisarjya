package com.project.bhaisarjya.modal;

public class ImportMedicine {
    private String Mname;
    private String mrp;
    private String quantity;
    private String amount;

    public ImportMedicine(String mname, String mrp, String quantity, String amount) {
        Mname = mname;
        this.mrp = mrp;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
