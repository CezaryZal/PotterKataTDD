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
    void shouldReturnPriceOfOneBook() {
        String priceOfOneBook = potter.buyBooks(1);
        assertThat(priceOfOneBook).isEqualTo("8.0€");
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
    void shouldThrowIfBasketIsEmpty(){
        Assertions.assertThrows(EmptyBasketException.class, () -> potter.buyBooks(0));
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
}