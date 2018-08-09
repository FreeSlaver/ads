package com.song.ads.unit4;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/3/28.
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("hell");
        List<Integer> list = Arrays.asList(10, 12, 20, 32, 50, 55, 65, 80, 99, 101);
        Integer result = binarySearch2(list, 12);
        System.out.println(result);
        Integer result2 = binarySearch2(list, 10);
        System.out.println(result2);
        Integer result3 = binarySearch2(list, 99);
        System.out.println(result3);
    }

    //草他妈的，怎么连个二分查找都不会写了R。
    //不断切分，直到index为1或者size-1，就是只剩下一个元素，无法再切分了。
    //返回下标
    //因为size/2是向下取整，所以没有很大问题
    public static Integer binarySearch(List<Integer> list, Integer item) {
        int size = list.size();
        int halfIndex = size / 2;

        while (true) {
            int v = list.get(halfIndex);
            if (item < v) {
                if (halfIndex == 0) {//not found
                    return null;
                }
                halfIndex = halfIndex / 2;
            } else if (item > v) {
                if (halfIndex == size - 1) {//not found
                    return null;
                }
                halfIndex = (halfIndex + size) / 2;
            } else {
                return halfIndex;
            }
        }
    }


    public static Integer binarySearch2(List<Integer> list, Integer item) {//这个是错的
        int first = 0;
        int last = list.size() - 1;
        int middle = (first + last) / 2;
        while (first <= last) {
            if (list.get(middle) < item) {
                first = middle + 1;
            } else if (list.get(middle) > item) {
                last = middle - 1;
            } else {
                return middle;
            }
        }
        return null;
    }
}
