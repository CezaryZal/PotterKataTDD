package com.CezaryZal;

import java.util.Arrays;
import java.util.List;

public class Potter {
    List<Integer> parsedBasket = Arrays.asList(0, 0, 0, 0, 0);
    private boolean parsedBasketIsEmpty;

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;

    public String buyBooks(int[] inputBasket) {
        parseBasket(inputBasket);
        double amountOfBooksWithDiscount = 0;

        while (!parsedBasketIsEmpty) {
            int numberOfDifferentBooks = calculateNumberOfDifferentBooksInBasket(inputBasket.length);
            double amountOfBooks = calculateValueOfBook(numberOfDifferentBooks);
            double discount = calculateDiscountByNumberOfDifferentBooks(numberOfDifferentBooks);
            amountOfBooksWithDiscount += amountOfBooks - amountOfBooks * discount;
        }
        return getPriceByAmountOfBooks(amountOfBooksWithDiscount);
    }

    private int calculateNumberOfDifferentBooksInBasket(int inputBasketLength) {
        int numberOfDifferentBooks = 0;
        parsedBasketIsEmpty = true;
        numberOfDifferentBooks = getNumberOfDifferentBooksByIncrement(inputBasketLength, numberOfDifferentBooks);
        return numberOfDifferentBooks;
    }

    private int getNumberOfDifferentBooksByIncrement(int inputBasketLength, int numberOfDifferentBooks) {
        for (int i = 0; i < parsedBasket.size(); i++) {
            if (numberOfDifferentBooks < 4 || !(inputBasketLength > 6)) {
                numberOfDifferentBooks = handleNumberOfBook(numberOfDifferentBooks, i, parsedBasket.get(i));
            }
            checkIfBasketStillHasBook(i);
        }
        return numberOfDifferentBooks;
    }

    private int handleNumberOfBook(int numberOfDifferentBooks, int iteration, int numberOfBooks) {
        if (numberOfBooks != 0) {
            numberOfDifferentBooks++;
            parsedBasket.set(iteration, --numberOfBooks);
        }
        return numberOfDifferentBooks;
    }

    private void checkIfBasketStillHasBook(int iteration) {
        if (parsedBasket.get(iteration) != 0) {
            parsedBasketIsEmpty = false;
        }
    }

    private void parseBasket(int[] InputBasket) {
        for (int numberOfBooks : InputBasket) {
            throwIfBasketContainsNegativeNumberOrUnknownBook(numberOfBooks);
            addBookToCorrectType(numberOfBooks);
        }
    }

    private void addBookToCorrectType(int numberOfBooks) {
        int numberOfFirstBooks = parsedBasket.get(numberOfBooks);
        parsedBasket.set(numberOfBooks, ++numberOfFirstBooks);
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
