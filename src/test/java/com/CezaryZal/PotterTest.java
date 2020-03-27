package com.CezaryZal;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PotterTest {

    private Potter potter;

    @BeforeEach
    void setUp() {
        potter = new Potter();
    }

    @Test
    void shouldReturnPriceOfFirstBook() {
        int[] basket = {0};
        String priceForOneFirstBook = potter.buyBooks(basket);
        assertThat(priceForOneFirstBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfSecondBook() {
        int[] basket = {1};
        String priceForOneSecondBook = potter.buyBooks(basket);
        assertThat(priceForOneSecondBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfThirdBook() {
        int[] basket = {2};
        String priceForOneThirdBook = potter.buyBooks(basket);
        assertThat(priceForOneThirdBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfFourthBook() {
        int[] basket = {3};
        String priceForOneFourthBook = potter.buyBooks(basket);
        assertThat(priceForOneFourthBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfFifthBook() {
        int[] basket = {4};
        String priceForOneFifthBook = potter.buyBooks(basket);
        assertThat(priceForOneFifthBook).isEqualTo("8.0€");
    }

    @Test
    void shouldThrowWhenBasketContainsNegativeNumber() {
        int[] basket = {-4};
        Assertions.assertThrows(EmptyBasketException.class, () -> potter.buyBooks(basket));
    }

    @Test
    void shouldReturnPriceOfTwoDifferentBooks() {
        int[] basket = {0, 1};
        String priceOfTwoDifferentBooks = potter.buyBooks(basket);
        assertThat(priceOfTwoDifferentBooks).isEqualTo("15.2€");
    }

    @Test
    void shouldReturnPriceOfThreeDifferentBooks() {
        int[] basket = {0, 1, 2};
        String priceOfThreeDifferentBooks = potter.buyBooks(basket);
        assertThat(priceOfThreeDifferentBooks).isEqualTo("21.6€");
    }

    @Test
    void shouldReturnPriceOfFourDifferentBooks() {
        int[] basket = {0, 1, 2, 3};
        String priceOfFourDifferentBooks = potter.buyBooks(basket);
        assertThat(priceOfFourDifferentBooks).isEqualTo("25.6€");
    }

    @Test
    void shouldReturnPriceOfFiveDifferentBooks() {
        int[] basket = {0, 1, 2, 3, 4};
        String priceOfFiveDifferentBooks = potter.buyBooks(basket);
        assertThat(priceOfFiveDifferentBooks).isEqualTo("30.0€");
    }

    @Test
    void shouldThrowWhenBasketContainsUnknownBook() {
        int[] basket = {1, 5};
        Assertions.assertThrows(IncorrectNumberOfBookException.class, () -> potter.buyBooks(basket));
    }

    @Test
    void shouldReturnPriceOfThreeDifferentBooksAndOneSameBook() {
        int[] basket = {0, 1, 2, 0};
        String priceOfFourBooks = potter.buyBooks(basket);
        assertThat(priceOfFourBooks).isEqualTo("29.6€");
    }

    @Test
    void shouldReturnPriceOfThreeDifferentBooksAndTwoSameBook() {
        int[] basket = {0, 1, 2, 0, 1};
        String priceOfFiveBooks = potter.buyBooks(basket);
        assertThat(priceOfFiveBooks).isEqualTo("36.8€");
    }

    @Test
    void shouldReturnPriceOfThreeDifferentBooksAndThreeSameBook() {
        int[] basket = {0, 0, 1, 0, 1, 3};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("44.8€");
    }

    @Test
    void shouldReturnPriceOfFiveDifferentBooksAndOneSameBook() {
        int[] basket = {0, 1, 1, 2, 3, 4};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("38.0€");
    }

    @Test
    void shouldReturnPriceOfForeDifferentBooksAndTwoSameBook() {
        int[] basket = {0, 0, 1, 1, 2, 3};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("40.8€");
    }

    @Test
    void shouldReturnPriceOfFourDifferentBooksAndThreeSameBook1() {
        int[] basket = {0, 0, 1, 1, 2, 2, 3, 4};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("51.2€");
    }

    @Test
    void shouldReturnPriceOfFourDifferentBooksAndThreeSameBook2() {
        int[] basket = {0, 1, 1, 2, 2, 3, 4, 4};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("51.2€");
    }

    @Test
    void shouldReturnPriceOfFiveDifferentBooksAndFiveSameBook() {
        int[] basket = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("60.0€");
    }

    @Test
    void shouldReturnPriceOfTwentyThreeDifferentBooks() {
        int[] basket = {0, 0, 0, 0, 0,
                1, 1, 1, 1, 1,
                2, 2, 2, 2,
                3, 3, 3, 3, 3,
                4, 4, 4, 4};
        String priceOfSixBooks = potter.buyBooks(basket);
        assertThat(priceOfSixBooks).isEqualTo("141.6€");
    }
}