package com.song.ads.unit1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 00013708 on 2017/8/21.
 */
public class MaxNumber {


    public static Integer max(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int max = 0;
        for (Integer num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    //使用二分查找
    public static Integer maxBinSearch(List<Integer> list) {

        int maxI = 0;
        int maxJ = 0;
        //二分查找，就使用2个指针
        for (int i = 0, j = list.size() - 1; i != j; i++, j--) {
            Integer numI = list.get(i);
            Integer numJ = list.get(j);

            if (numI > maxI) {
                maxI = numI;
            }
            if (numJ > maxJ) {
                maxJ = numJ;
            }
        }

        return maxI > maxJ ? maxI : maxJ;
    }

    //使用递归
    public static Integer maxRecursive(List<Integer> list) {
        int max = 0;

/*        for (Integer num : list) {
            max = max(max, num);
        }*/
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            max = max(max, num);
        }
        return max;
    }

    private static Integer max(Integer x, Integer y) {
        return x >= y ? x : y;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 100, 300, 232, 45, 77);
        Integer max = max(list);
        System.out.println(max);

        Integer max2 = maxRecursive(list);
        System.out.println(max2);

        Integer max3 = maxBinSearch(list);
        System.out.println(max3);

    }
}
