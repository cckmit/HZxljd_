package com.ruoyi.common.utils;

import java.math.BigDecimal;

public class NumUtils {

    public static double rate(BigDecimal num, BigDecimal mum1){
        if(mum1.compareTo(BigDecimal.ZERO) < 1){
            return 0.00;
        }
        return num.divide(mum1,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).doubleValue();
    }
}
