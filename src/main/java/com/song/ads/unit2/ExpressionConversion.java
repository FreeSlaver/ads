package com.song.ads.unit2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 00013708 on 2017/9/6.
 */
@SuppressWarnings("ALL")
public class ExpressionConversion {

    public static void main(String[] args) {
        String exp1 = "D=A+B*C";
        //将这个鸟东西转换成"DABC*+="

        //1.得到所有的操作符，然后按照那个优先级从高到低排列，然后和前面的字符搞起来就完了。
        List<Operator> list = new ArrayList<Operator>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp1.length(); i++) {
            char ch = exp1.charAt(i);
            String chStr = String.valueOf(ch);

            Operator op = Operator.get(chStr);
            if (op != null) {
                list.add(op);
            }else{
                sb.append(chStr);
            }
        }
        list.sort(new Comparator<Operator>() {
            public int compare(Operator o1, Operator o2) {
                return o2.getPriority() -o1.getPriority();
            }
        });
        if(list!=null&&list.size()>0){
            for(Operator op:list){
                sb.append(op.getVal());
            }
        }

        System.out.println(sb);
    }

}
