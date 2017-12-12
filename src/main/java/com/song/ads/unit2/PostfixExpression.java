package com.song.ads.unit2;

import java.util.Stack;

/**
 * Created by 00013708 on 2017/9/12.
 */
public class PostfixExpression {
    public static void main(String[] args) {

        String postfixExp = "5 4 + 8 2 - *";//计算出值
        /**
         * 首先将5，3，进栈，遇到操作符，取出来5，3并赋值，使用操作符计算，得到结果，入栈；
         * 然后将8，2 进去，遇到-，计算，得到结果6，进去
         * 然后又遇到一个*，将剩下的2个拿出来，计算拿到结果。
         */
        /*for(int i=0;i<postfixExp.length();i++){
            String str = String.valueOf(postfixExp.charAt(i));
            if(str.equals(" ")){

            }
        }*/
        java.util.Stack<String> stack = new Stack<String>();
        String[] strArr = postfixExp.split(" ");
        for(String str:strArr){
            if(Operator.isOperator(str)){
                String val2 = stack.pop();
                String val1 = stack.pop();

                Integer result = null;
                if(str.equals("+")){
                    result = Integer.valueOf(val1)+Integer.valueOf(val2);
                }else if(str.equals("-")){
                    result = Integer.valueOf(val1)-Integer.valueOf(val2);
                }else if(str.equals("*")){
                    result = Integer.valueOf(val1)*Integer.valueOf(val2);
                }else if(str.equals("/")){
                    result = Integer.valueOf(val1)/Integer.valueOf(val2);
                }
                stack.push(result.toString());
            }else{
                stack.push(str);
            }
        }
        System.out.println(stack.pop());

    }
}
