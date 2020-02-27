package au.com.halogo.service;

import au.com.halogo.HalogoApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = HalogoApp.class)
public class TransformServiceT {

    @Autowired
    private TransformService transformService;

    @Test
    public void checkTransform() {
        assertThat(transformService.convertNumberToWord(new BigDecimal("0")))
            .isEqualTo("ZERO CENT");

        assertThat(transformService.convertNumberToWord(new BigDecimal("0.0")))
            .isEqualTo("ZERO CENT");

        assertThat(transformService.convertNumberToWord(new BigDecimal("0.01")))
            .isEqualTo("ONE CENT");

        assertThat(transformService.convertNumberToWord(new BigDecimal("0.45")))
            .isEqualTo("FORTY-FIVE CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("0.4")))
            .isEqualTo("FORTY CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("0.45444")))
            .isEqualTo("FORTY-FIVE CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("0.45666")))
            .isEqualTo("FORTY-SIX CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("1.40")))
            .isEqualTo("ONE DOLLAR AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("2.40")))
            .isEqualTo("TWO DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("3.40")))
            .isEqualTo("THREE DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("4.40")))
            .isEqualTo("FOUR DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("5.40")))
            .isEqualTo("FIVE DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("6.40")))
            .isEqualTo("SIX DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("7.40")))
            .isEqualTo("SEVEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("8.40")))
            .isEqualTo("EIGHT DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("9.40")))
            .isEqualTo("NINE DOLLARS AND FORTY CENTS");


        assertThat(transformService.convertNumberToWord(new BigDecimal("10.4")))
            .isEqualTo("TEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("11.4")))
            .isEqualTo("ELEVEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("12.4")))
            .isEqualTo("TWELVE DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("13.4")))
            .isEqualTo("THIRTEEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("14.4")))
            .isEqualTo("FOURTEEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("15.4")))
            .isEqualTo("FIFTEEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("16.4")))
            .isEqualTo("SIXTEEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("17.4")))
            .isEqualTo("SEVENTEEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("18.4")))
            .isEqualTo("EIGHTEEN DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("19.4")))
            .isEqualTo("NINETEEN DOLLARS AND FORTY CENTS");


        assertThat(transformService.convertNumberToWord(new BigDecimal("20.4")))
            .isEqualTo("TWENTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("30.4")))
            .isEqualTo("THIRTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("40.4")))
            .isEqualTo("FORTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("50.4")))
            .isEqualTo("FIFTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("60.4")))
            .isEqualTo("SIXTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("70.4")))
            .isEqualTo("SEVENTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("80.4")))
            .isEqualTo("EIGHTY DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("90.4")))
            .isEqualTo("NINETY DOLLARS AND FORTY CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("100")))
            .isEqualTo("ONE HUNDRED DOLLARS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("100.4")))
            .isEqualTo("ONE HUNDRED DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("103.4")))
            .isEqualTo("ONE HUNDRED AND THREE DOLLARS AND FORTY CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("123.4")))
            .isEqualTo("ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("1004.56")))
            .isEqualTo("ONE THOUSAND FOUR DOLLARS AND FIFTY-SIX CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("1034.56")))
            .isEqualTo("ONE THOUSAND THIRTY-FOUR DOLLARS AND FIFTY-SIX CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("1234.56")))
            .isEqualTo("ONE THOUSAND TWO HUNDRED AND THIRTY-FOUR DOLLARS AND FIFTY-SIX CENTS");


        assertThat(transformService.convertNumberToWord(new BigDecimal("10005.67")))
            .isEqualTo("TEN THOUSAND FIVE DOLLARS AND SIXTY-SEVEN CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("10045.67")))
            .isEqualTo("TEN THOUSAND FORTY-FIVE DOLLARS AND SIXTY-SEVEN CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("10345.67")))
            .isEqualTo("TEN THOUSAND THREE HUNDRED AND FORTY-FIVE DOLLARS AND SIXTY-SEVEN CENTS");
        assertThat(transformService.convertNumberToWord(new BigDecimal("12345.67")))
            .isEqualTo("TWELVE THOUSAND THREE HUNDRED AND FORTY-FIVE DOLLARS AND SIXTY-SEVEN CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("123456.78")))
            .isEqualTo("ONE LAKH TWENTY-THREE THOUSAND FOUR HUNDRED AND FIFTY-SIX DOLLARS AND SEVENTY-EIGHT CENTS");


        assertThrows(IllegalArgumentException.class,
            () -> transformService.convertNumberToWord(null), "Money is NULL!");
        assertThrows(IllegalArgumentException.class,
            () -> transformService.convertNumberToWord(new BigDecimal("a")), "Money is NULL!");
        assertThrows(IllegalArgumentException.class,
            () -> transformService.convertNumberToWord(new BigDecimal("-1")), "Money less then zero!");
        assertThrows(IllegalArgumentException.class,
            () -> transformService.convertNumberToWord(new BigDecimal("999999999")), "Money bigger then 1 million!");
    }

}
