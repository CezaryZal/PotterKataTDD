package com.CezaryZal;


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
        String priceOfTwoBooks = potter.buyBooks(3);
        assertThat(priceOfTwoBooks).isEqualTo("21.6€");
    }
}