package com.song.ads.unit3.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/3/27.
 * 多观察特定，并将很多的特点共用，抽象出来
 */
public class GraphAdjacencyMatrix {

    public static void main(String[] args) {


    }
    //根据这个matrix求出所有的edges
    public static void incidenceMatrix() {
        List<String> vertices = Arrays.asList("A", "B", "C", "D", "E");
        List<String> edges = Arrays.asList("E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8");
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 1, -1, 0, 0, 0, 0, 0);
        List<Integer> list2 = Arrays.asList(-1, 0, 0, 1, 0, 1, 0, 0);
        List<Integer> list3 = Arrays.asList(0, -1, 0, 0, 1, 0, 0, 0);
        List<Integer> list4 = Arrays.asList(0, 0, 1, -1, -1, 0, 1, 1);
        List<Integer> list5 = Arrays.asList(0, 0, 0, 0, 0, -1, -1, 0);
        matrix.add(list1);
        matrix.add(list2);
        matrix.add(list3);
        matrix.add(list4);
        matrix.add(list5);

    }

    public static void adjacencyMatrix() {
        List<String> vertices = Arrays.asList("A", "B", "C", "D", "E");
        //N个顶点，使用N*N的矩阵；1表示从行到列有edge，0表示没有。
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(0, 1, 1, 1, 0);
        List<Integer> list2 = Arrays.asList(1, 0, 0, 1, 1);
        List<Integer> list3 = Arrays.asList(1, 0, 0, 1, 0);
        List<Integer> list4 = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> list5 = Arrays.asList(0, 1, 0, 1, 0);

        matrix.add(list1);
        matrix.add(list2);
        matrix.add(list3);
        matrix.add(list4);
        matrix.add(list5);

        //打印所有edges
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {//遍历的行
            List<Integer> list = matrix.get(i);
            for (int j = i; j < list.size(); j++) {//遍历行中的列
                Integer v = list.get(j);
                if (v == 1) {
                    //先得到行号，就是i
                    String startVertex = vertices.get(i);
                    //再得到列号，就是j
                    String endVertext = vertices.get(j);
                    //组合起来就成从行到列的edge了
                    String edge = null;
                    //要得到<->的效果
                    if (matrix.get(j).get(i) == 1) {//就是<->这种无向列表了
                        edge = startVertex + "<->" + endVertext;
                    } else {
                        edge = startVertex + "->" + endVertext;
                    }
                    edges.add(edge);
                }
            }
        }
        System.out.println(Arrays.toString(edges.toArray()));
        //[A->B, A->C, A->D, B->A, B->D, B->E, C->A, C->D, D->A, D->B, D->C, D->D, D->E, E->B, E->D]
        //我现在想要这种显示A<->B，如果是无向的，怎么搞了？遍历结果集，然后将->替换成<->，因为上面的东西很通用，不用再改了
        //先拿到A->B，如果再碰到B->A，那么僵A->B替换成A<->B
        //不对，其实还有一种方法，等于1之后，翻转行列
    }
}
