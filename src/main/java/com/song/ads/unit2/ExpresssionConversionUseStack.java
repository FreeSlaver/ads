package com.song.ads.unit2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by 00013708 on 2017/9/12.
 */
public class ExpresssionConversionUseStack {

    private static final List<String> operands = Arrays.asList("+", "-", "*", "/", "%", "+", "=");

    public static void main(String[] args) {
        String exp = "( A + B ) * ( C - D )";

        java.util.Stack<String> stack = new Stack<String>();
        exp = exp.replace(" ", "");
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            String chStr = String.valueOf(ch);
            if (Operator.isOperator(chStr)) {//先遍历出优先级比此操作符优先级高的
                Operator chOp = Operator.get(chStr);
                if (stack.empty()) {
                    stack.push(chStr);
                } else {
                    //找出比此operator优先级高的并已经在此stack中的，如果有，将这些pop出来并打印
                    Iterator<String> ite = stack.iterator();
                    while (ite.hasNext()) {
                        String str = ite.next();
                        Operator ope = Operator.get(str);
                        if (ope != null && ope.getPriority() < chOp.getPriority()) {
                            String popTemp = stack.pop();
                            System.out.println(popTemp);
                        }
                    }
                    stack.push(chStr);
                }

            } else if (chStr.equals("(")) {//入栈
                stack.push(chStr);
            } else if (chStr.equals(")")) {//所有元素出栈，直到遇到左括号
                String popTemp = null;
                while (!(popTemp=stack.pop()).equals("(")) {
                    System.out.println(popTemp);
                }
                //我草，这个地方真蛋疼，将所有的pop出来并打印，直到遇到(。
                /*while (!stack.empty() && !"(".equals(popTemp)){
                    popTemp = stack.pop();
                    System.out.println(popTemp);
                }*/

            } else {
                System.out.println(chStr);
            }

        }
//        A B + C D - *
    }


}
