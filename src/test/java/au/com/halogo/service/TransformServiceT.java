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
        assertThat(transformService.convertNumberToWord(new BigDecimal("123.45")))
            .isEqualTo("ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("100")))
            .isEqualTo("ONE HUNDRED DOLLARS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("0.45")))
            .isEqualTo("FORTY-FIVE CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("123.40")))
            .isEqualTo("ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("100.40")))
            .isEqualTo("ONE HUNDRED DOLLARS AND FORTY CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("1.40")))
            .isEqualTo("ONE DOLLAR AND FORTY CENTS");

        assertThat(transformService.convertNumberToWord(new BigDecimal("123.01")))
            .isEqualTo("ONE HUNDRED AND TWENTY-THREE DOLLARS AND ONE CENT");

        assertThat(transformService.convertNumberToWord(new BigDecimal("1235.67")))
            .isEqualTo("ONE THOUSAND TWO HUNDRED AND THIRTY-FIVE DOLLARS AND SIXTY-SEVEN CENTS");

        assertThrows(IllegalArgumentException.class,
            () -> transformService.convertNumberToWord(null), "Money is NULL!");
    }

}
