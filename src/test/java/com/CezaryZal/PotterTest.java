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
        int [] basket = {0};
        String priceForOneFirstBook = potter.buyBooks(basket);
        assertThat(priceForOneFirstBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfSecondBook() {
        int [] basket = {1};
        String priceForOneSecondBook = potter.buyBooks(basket);
        assertThat(priceForOneSecondBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfThirdBook() {
        int [] basket = {2};
        String priceForOneThirdBook = potter.buyBooks(basket);
        assertThat(priceForOneThirdBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfFourthBook() {
        int [] basket = {3};
        String priceForOneFourthBook = potter.buyBooks(basket);
        assertThat(priceForOneFourthBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfFifthBook() {
        int [] basket = {4};
        String priceForOneFifthBook = potter.buyBooks(basket);
        assertThat(priceForOneFifthBook).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfTwoBooks(){
        String priceOfTwoBooks = potter.buyBooks(2);
        assertThat(priceOfTwoBooks).isEqualTo("15.2€");
    }

    @Test
    void shouldReturnPriceOfThreeBooks(){
        String priceOfThreeBooks = potter.buyBooks(3);
        assertThat(priceOfThreeBooks).isEqualTo("21.6€");
    }

    @Test
    void shouldReturnPriceOfFourBooks(){
        String priceOfFourBooks = potter.buyBooks(4);
        assertThat(priceOfFourBooks).isEqualTo("25.6€");
    }

    @Test
    void shouldReturnPriceOfFiveBooks(){
        String priceOfFiveBooks = potter.buyBooks(5);
        assertThat(priceOfFiveBooks).isEqualTo("30.0€");
    }

    @Test
    void shouldThrowWhenBasketContainsNegativeNumber(){
        Assertions.assertThrows(EmptyBasketException.class, () -> potter.buyBooks(-2));
    }

    @Test
    void shouldReturnPriceOfThreeDifferentBooksAndOneSameBook(){
        String priceOfFourBooks = potter.buyBooks(3, 1);
        assertThat(priceOfFourBooks).isEqualTo("29.6€");
    }

    @Test
    void shouldReturnPriceOfThreeDifferentBooksAndTwoSameBook(){
        String priceOfFiveBooks = potter.buyBooks(3, 2);
        assertThat(priceOfFiveBooks).isEqualTo("37.6€");
    }
}