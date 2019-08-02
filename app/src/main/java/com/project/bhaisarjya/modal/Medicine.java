package com.project.bhaisarjya.modal;

public class Medicine {
    private String name;
    private String category;
    private String composition;
    private String rate;

    public Medicine(String name, String category, String composition, String rate) {
        this.name = name;
        this.category = category;
        this.composition = composition;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
