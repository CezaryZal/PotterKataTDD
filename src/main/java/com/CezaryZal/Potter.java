package com.CezaryZal;

public class Potter {

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;

    public String buyBooks(int numberOfDifferentBooks, int numberOfSameBook) {
        throwIfBasketContainsNegativeNumber(numberOfSameBook);
        double amountOfBooks = calculateValueOfBookIncludingDiscount(numberOfDifferentBooks) +
                priceOfOneBook;

        return getPriceFromBasket(amountOfBooks);
    }

    public String buyBooks(int numberOfDifferentBooks) {
        throwIfBasketContainsNegativeNumber(numberOfDifferentBooks);
        double amountOfBooks = calculateValueOfBookIncludingDiscount(numberOfDifferentBooks);

        return getPriceFromBasket(amountOfBooks);
    }

    private double calculateValueOfBookIncludingDiscount(int numberOfBooks){
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
        double amountOfBooks = priceOfOneBook * numberOfBooks;

        return amountOfBooks - amountOfBooks * discount;
    }

    private void throwIfBasketContainsNegativeNumber(int numberOfBooks) {
        if (numberOfBooks < 1){
            throw new EmptyBasketException();
        }
    }

    private String getPriceFromBasket(double priceOfBooks) {
        return priceOfBooks + euroMark;
    }
}
