package au.com.halogo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static au.com.halogo.utils.NumberConvertUtil.convert;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;

/**
 * convert money from number to word
 */
@Service
public class TransformService {
    public static final String DOLLAR = "DOLLAR";
    public static final String DOLLARS = "DOLLARS";
    public static final String CENT = "CENT";
    public static final String CENTS = "CENTS";
    public static final String AND = "AND";
    public static final BigDecimal MAX_VALUE = new BigDecimal("1000000");
    public static final String ZERO = "ZERO";

    public String convertNumberToWord(BigDecimal money) {
        assertNotNull(money, "Money can NOT be null!");
        assertTrue(money.compareTo(BigDecimal.ZERO) >= 0, "Money need large than or equal ZERO");
        assertTrue(money.compareTo(MAX_VALUE) <= 0, "Money need less than 1 million");
        if (money.compareTo(BigDecimal.ZERO) == 0) {
           return ZERO + " " + CENT;
        }
        int dollars = money.setScale(0, BigDecimal.ROUND_DOWN).intValue();
        int cents = money.subtract(BigDecimal.valueOf(dollars))
            .multiply(BigDecimal.valueOf(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        StringBuilder word = new StringBuilder();
        if (dollars > 0) {
            word.append(convert(dollars));
            word.append(" ");
            word.append(dollars > 1 ? DOLLARS : DOLLAR);
        }
        if (cents > 0) {
            if (dollars > 0) {
                word.append(" ");
                word.append(AND);
                word.append(" ");
            }
            word.append(convert(cents));
            word.append(" ");
            word.append(cents > 1 ? CENTS : CENT);
        }
        return word.toString().toUpperCase();
    }


}
