package com.CezaryZal;

public class Potter {

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;


    public String buyBooks(int numberOfBooks) {
        throwIfBasketIsEmpty(numberOfBooks);

        double discount = 0;
        switch (numberOfBooks) {
            case 2: {
                discount = 0.05;;
                break;
            }
            case 3: {
                discount = 0.1;
                break;
            }
            case 4: {
                discount = 0.2;
                break;
            }
            case 5: {
                discount = 0.25;
                break;
            }
        }
        double priceOfBooks = calculateValueOfBookIncludingDiscount(numberOfBooks, discount);

        return getPriceFromBasket(priceOfBooks);
    }

    private void throwIfBasketIsEmpty(int numberOfBooks) {
        if (numberOfBooks < 1){
            throw new EmptyBasketException();
        }
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
