package com.CezaryZal;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PotterTest {

    @Test
    void shouldReturnPriceOfOneBook() {
        Potter potter = new Potter();
        assertThat(potter.buyBooks(1)).isEqualTo("8.0€");
    }

    @Test
    void shouldReturnPriceOfTwoBook(){
        Potter potter = new Potter();
        assertThat(potter.buyBooks(2)).isEqualTo("15.2€");
    }
}