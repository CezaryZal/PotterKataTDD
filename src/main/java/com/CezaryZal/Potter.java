package com.CezaryZal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Potter {

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;

    public String buyBooks(int[] inputBasket) {
        List<Integer> parsedBasketForFirstOption = parseBasket(inputBasket);
        double amountOfBooksWithDiscount1 =
                getAmountOfBooksWithDiscount(inputBasket.length, 4, parsedBasketForFirstOption);
        List<Integer> parsedBasketForSecondOption = parseBasket(inputBasket);
        double amountOfBooksWithDiscount2 =
                getAmountOfBooksWithDiscount(inputBasket.length, 5, parsedBasketForSecondOption);

        return amountOfBooksWithDiscount1 < amountOfBooksWithDiscount2 ?
                getPriceByAmountOfBooks(amountOfBooksWithDiscount1) : getPriceByAmountOfBooks(amountOfBooksWithDiscount2);
    }

    private double getAmountOfBooksWithDiscount(int inputBasketLength, int numberForOption, List<Integer> parsedBasket) {
        boolean parsedBasketIsEmpty = false;
        double amountOfBooksWithDiscount = 0;

        while (!parsedBasketIsEmpty) {
            int numberOfDifferentBooks = 0;
            parsedBasketIsEmpty = true;
            List<Integer> tmpParsedBasket = new ArrayList<>(parsedBasket);

            for (Integer bookType : parsedBasket) {

                if (tmpParsedBasket.stream().mapToInt((a) -> a).sum() != 0) {
                    int maxNumber = 0;
                    int position = 0;

                    for (int j = 0; j < 5; j++) {
                        if (tmpParsedBasket.get(j) > maxNumber) {
                            maxNumber = tmpParsedBasket.get(j);
                            position = j;
                        } else if (tmpParsedBasket.get(j) != 0) {
                            tmpParsedBasket.set(j, parsedBasket.get(j));
                        }
                    }
                    tmpParsedBasket.set(position, 0);
                    if ((numberOfDifferentBooks < numberForOption || !(inputBasketLength > 6)) &&
                            parsedBasket.get(position) != 0) {

                        numberOfDifferentBooks++;
                        Integer currentNumberOfBook = parsedBasket.get(position);
                        parsedBasket.set(position, --currentNumberOfBook);
                        parsedBasketIsEmpty = isParsedBasketIsEmpty(parsedBasket.get(position));
                    }

                }
            }
            double amountOfBooks = calculateValueOfBook(numberOfDifferentBooks);
            double discount = calculateDiscountByNumberOfDifferentBooks(numberOfDifferentBooks);
            amountOfBooksWithDiscount += amountOfBooks - amountOfBooks * discount;
        }
        return amountOfBooksWithDiscount;
    }

    private boolean isParsedBasketIsEmpty(int currentNumberOfBooksOfSpecificType) {
        return currentNumberOfBooksOfSpecificType == 0;
    }
//    private int calculateNumberOfDifferentBooksInBasket(int inputBasketLength) {


//    private int handleNumberOfBook(int numberOfDifferentBooks, int iteration, int numberOfBooks) {


    private List<Integer> parseBasket(int[] InputBasket) {
        List<Integer> parsedBasket = Arrays.asList(0, 0, 0, 0, 0);
        for (int numberOfBooks : InputBasket) {
            throwIfBasketContainsNegativeNumberOrUnknownBook(numberOfBooks);

            int numberOfFirstBooks = parsedBasket.get(numberOfBooks);
            parsedBasket.set(numberOfBooks, ++numberOfFirstBooks);
        }
        return parsedBasket;
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
