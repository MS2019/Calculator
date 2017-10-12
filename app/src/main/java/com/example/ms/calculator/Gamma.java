package com.example.ms.calculator;

/**
 * Created by MS on 2017/9/16.
 */

public class Gamma {                  //伽玛函数计算小数的阶乘

    public double gamma(double num){
        double t = (num - 0.5) * Math.log(num+4.5) - (num + 4.5);
        double s = 1.0 + 76.18009173 / (num + 0) - 86.50532033 / (num + 1)
                + 24.01409822 / (num + 2) - 1.231739516 / (num + 3)
                + 0.00120858003 / (num + 4) - 0.00000536382 / (num + 5);
        double w = t + Math.log(s * Math.sqrt(2 * Math.PI));
        double x = Math.exp(w);
        return x;
    }
}
