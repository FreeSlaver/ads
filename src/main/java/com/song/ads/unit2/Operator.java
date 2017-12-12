package com.song.ads.unit2;

import java.util.Arrays;

/**
 * Created by 00013708 on 2017/9/6.
 */
public enum Operator {

    EQUAL_TO("=", 2),
    ADD("+", 4),
    SUBTRACT("-", 4),
    MULTIPLY("*", 5),
    DIVIDE("/", 5),;
    private int priority;

    private String val;


    Operator(String val, int priority) {
        this.priority = priority;
        this.val = val;
    }


    public int getPriority() {

        return priority;
    }

    public String getVal() {
        return val;
    }

    public static Operator get(String str) {
        Operator[] ops = Operator.values();
        Operator result = null;
        for (Operator op : ops) {
            if (op.getVal().equalsIgnoreCase(str)) {
                result = op;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return this.val;
    }

    public static boolean isOperator(String chStr) {
        return get(chStr) != null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Operator.values()));

    }
}
