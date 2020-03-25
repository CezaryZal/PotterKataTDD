package com.CezaryZal;

import java.util.HashMap;
import java.util.Map;

public class Potter {

    private final String euroMark = "€";
    private final double priceOfOneBook = 8.0;

    public String buyBooks(int[] basket) {
        Map<String, Integer> orderedBasket = parseBasket(basket);

        int allBooksInBasket = orderedBasket.values().stream().mapToInt(a -> a).sum();

        double amountOfBooks = calculateValueOfBook(allBooksInBasket);

        return getPriceByAmountOfBooks(amountOfBooks);
    }

    public String buyBooks(int numberOfDifferentBooks, int numberOfSameBook) {
        throwIfBasketContainsNegativeNumber(numberOfSameBook);
        double amountOfBooks = calculateValueOfBookIncludingDiscount(numberOfDifferentBooks) +
                calculateValueOfBook(numberOfSameBook);

        return getPriceByAmountOfBooks(amountOfBooks);
    }

    public String buyBooks(int numberOfDifferentBooks) {
        throwIfBasketContainsNegativeNumber(numberOfDifferentBooks);
        double amountOfBooks = calculateValueOfBookIncludingDiscount(numberOfDifferentBooks);

        return getPriceByAmountOfBooks(amountOfBooks);
    }

    private Map<String, Integer> parseBasket(int[] basket) {
        Map<String, Integer> orderedBasket = new HashMap<>();
        orderedBasket.put("First", 0);
        orderedBasket.put("Second", 0);
        orderedBasket.put("Third", 0);
        orderedBasket.put("Fourth", 0);
        orderedBasket.put("Fifth", 0);

        for (int book : basket) {
            throwIfBasketContainsNegativeNumber(book);
            switch (book) {
                case 0: {
                    Integer numberOfFirstBooks = orderedBasket.get("First");
                    orderedBasket.replace("First", ++numberOfFirstBooks);
                    break;
                }
                case 1: {
                    Integer numberOfSecondBooks = orderedBasket.get("Second");
                    orderedBasket.replace("Second", ++numberOfSecondBooks);
                    break;
                }
                case 2: {
                    Integer numberOfThirdBooks = orderedBasket.get("Third");
                    orderedBasket.replace("Third", ++numberOfThirdBooks);
                    break;
                }
                case 3: {
                    Integer numberOfFourthBooks = orderedBasket.get("Fourth");
                    orderedBasket.replace("Fourth", ++numberOfFourthBooks);
                    break;
                }
                case 4: {
                    Integer numberOfFifthBooks = orderedBasket.get("Fifth");
                    orderedBasket.replace("Fifth", ++numberOfFifthBooks);
                    break;
                }
            }
        }
        return orderedBasket;
    }

    private double calculateValueOfBook(int numberOfBooks) {
        return numberOfBooks * priceOfOneBook;
    }

    private double calculateValueOfBookIncludingDiscount(int numberOfBooks) {
        double discount = 0;
        switch (numberOfBooks) {
            case 2: {
                discount = 0.05;
                ;
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
        double amountOfBooks = calculateValueOfBook(numberOfBooks);

        return amountOfBooks - amountOfBooks * discount;
    }

    private void throwIfBasketContainsNegativeNumber(int numberOfBooks) {
        if (numberOfBooks < 0) {
            throw new EmptyBasketException();
        }
    }

    private String getPriceByAmountOfBooks(double amountOfBooks) {
        return amountOfBooks + euroMark;
    }
}
