package com.CezaryZal;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PotterTest {

    @Test
    void shouldReturnPriceOfOneBook() {
        Potter potter = new Potter();
        assertThat(potter.getPriceFromBasket()).isEqualTo("8€");
    }
}