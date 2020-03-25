package com.CezaryZal;

public class Potter {
    private int[] parsedBasket = new int[5];

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;

    public String buyBooks(int[] inputBasket) {
        parseBasket(inputBasket);

        int numberOfDifferentBooks = calculateNumberOfDifferentBooksInBasket();
        double amountOfBooks = calculateValueOfBook(numberOfDifferentBooks);

        double discount = calculateDiscountByNumberOfDifferentBooks(numberOfDifferentBooks);
        double amountOfBooksWithDiscount = amountOfBooks - amountOfBooks * discount;


        return getPriceByAmountOfBooks(amountOfBooksWithDiscount);
    }

    private int calculateNumberOfDifferentBooksInBasket() {
        int numberOfDifferentBooks = 0;

        for (int i = 0; i < parsedBasket.length; i++) {
            int numberOfBooks = parsedBasket[i];

            if (numberOfBooks != 0) {
                numberOfDifferentBooks++;
                parsedBasket[i] = --numberOfBooks;
            }

        }
        return numberOfDifferentBooks;
    }

    private void parseBasket(int[] InputBasket) {
        for (int numberOfBooks : InputBasket) {
            throwIfBasketContainsNegativeNumberOrUnknownBook(numberOfBooks);
            addBookToCorrectType(numberOfBooks);
        }
    }

    private void addBookToCorrectType(int numberOfBooks) {
        int numberOfFirstBooks = parsedBasket[numberOfBooks];
        parsedBasket[numberOfBooks] = ++numberOfFirstBooks;
    }

    private double calculateValueOfBook(int numberOfBooks) {
        return numberOfBooks * priceOfOneBook;
    }

    private double calculateDiscountByNumberOfDifferentBooks(int numberOfBooks) {
        double discount = 0;
        switch (numberOfBooks) {
            case 2: {
                discount = 0.05;
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
        return discount;
    }

    private void throwIfBasketContainsNegativeNumberOrUnknownBook(int numberOfBooks) {
        if (numberOfBooks < 0) {
            throw new EmptyBasketException();
        } else if (numberOfBooks > 4) {
            throw new IncorrectNumberOfBookException();
        }
    }

    private String getPriceByAmountOfBooks(double amountOfBooks) {
        return amountOfBooks + euroMark;
    }
}
