package com.CezaryZal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Potter {

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;

    public String buyBooks(int[] inputBasket) {
        List<Integer> parsedBasketForFirstOption = parseBasket(inputBasket);
        List<Integer> parsedBasketForSecondOption = parseBasket(inputBasket);

        return getPriceByAmountOfBooks(Math.min(
                getAmountOfBooksWithDiscount(inputBasket.length, 4, parsedBasketForFirstOption),
                getAmountOfBooksWithDiscount(inputBasket.length, 5, parsedBasketForSecondOption)));
    }

    private double getAmountOfBooksWithDiscount(int inputBasketLength, int numberForOption, List<Integer> parsedBasket) {
        boolean parsedBasketIsEmpty = false;
        double amountOfBooksWithDiscount = 0;

        while (!parsedBasketIsEmpty) {
            List<Integer> tmpParsedBasket = new ArrayList<>(parsedBasket);
            parsedBasketIsEmpty = true;
            int numberOfDifferentBooks = 0;

            for (Integer bookType : parsedBasket) {

                if (getSumOfTmpParsedBasket(tmpParsedBasket) != 0) {

                    int index = indexForHighestValue(tmpParsedBasket, parsedBasket);
                    tmpParsedBasket.set(index, 0);

                    if ((numberOfDifferentBooks < numberForOption || !(inputBasketLength > 6)) &&
                            parsedBasket.get(index) != 0) {

                        numberOfDifferentBooks++;
                        Integer currentNumberOfBook = parsedBasket.get(index);
                        parsedBasket.set(index, --currentNumberOfBook);
                    }
                    parsedBasketIsEmpty = isParsedBasketIsEmpty(parsedBasketIsEmpty, parsedBasket.get(index));
                }
            }
            double amountOfBooks = calculateValueOfBook(numberOfDifferentBooks);
            double discount = calculateDiscountByNumberOfDifferentBooks(numberOfDifferentBooks);
            amountOfBooksWithDiscount += amountOfBooks - amountOfBooks * discount;
        }
        return amountOfBooksWithDiscount;
    }

    private int indexForHighestValue(List<Integer> tmpParsedBasket, List<Integer> parsedBasket){
        int maxNumber = 0;
        int index = 0;
        
        for (int j = 0; j < 5; j++) {
            if (tmpParsedBasket.get(j) > maxNumber) {
                maxNumber = tmpParsedBasket.get(j);
                index = j;
            } else if (tmpParsedBasket.get(j) != 0) {
                tmpParsedBasket.set(j, parsedBasket.get(j));
            }
        }
        return index;
    }

    private int getSumOfTmpParsedBasket(List<Integer> tmpParsedBasket) {
        return tmpParsedBasket.stream().mapToInt((a) -> a).sum();
    }

    private boolean isParsedBasketIsEmpty(boolean parsedBasketIsEmpty, int currentNumberOfBooksOfSpecificType) {
        if (currentNumberOfBooksOfSpecificType != 0) {
            parsedBasketIsEmpty = false;
        }
        return parsedBasketIsEmpty;
    }

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
