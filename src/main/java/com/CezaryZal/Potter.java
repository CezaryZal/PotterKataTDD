package com.CezaryZal;

public class Potter {

    private final String euroMark = "€";
    private double priceOfOneBook = 8.0;



    public String buyBooks(int numberOfBooks) {
        if (numberOfBooks == 2){
            return getPriceForTwoBooksWithDiscount();
        }
        return getPriceForOneBook();
    }

    private String getPriceForTwoBooksWithDiscount(){
        double amountOfBooks = priceOfOneBook * 2;
        double discount = 0.05;

        return amountOfBooks - amountOfBooks * discount + euroMark;
    }

    private String getPriceForOneBook() {
        return priceOfOneBook + euroMark;
    }
}
