package com.CezaryZal;

public class Potter {

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;


    public String buyBooks(int numberOfBooks) {
        double priceOfBooks = 0;
        switch (numberOfBooks) {
            case 1: {
                priceOfBooks = calculateValueOfBookIncludingDiscount(1, 0);
                break;
            }
            case 2: {
                priceOfBooks = calculateValueOfBookIncludingDiscount(2, 0.05);
                break;
            }
            case 3: {
                priceOfBooks = calculateValueOfBookIncludingDiscount(3, 0.1);
                break;
            }
        }
        return getPriceFromBasket(priceOfBooks);
    }

    private double calculateValueOfBookIncludingDiscount(
            int numberOfBooks, double discount){

        double amountOfBooks = priceOfOneBook * numberOfBooks;
        return amountOfBooks - amountOfBooks * discount;
    }

    private String getPriceFromBasket(double priceOfBooks) {
        return priceOfBooks + euroMark;
    }
}
