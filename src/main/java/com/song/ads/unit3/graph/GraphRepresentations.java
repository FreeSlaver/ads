package com.song.ads.unit3.graph;

import java.util.*;

/**
 * Created by 001844 on 2018/3/27.
 * 多观察特定，并将很多的特点共用，抽象出来
 */
public class GraphRepresentations {

    public static void main(String[] args) {
//        incidenceMatrix();
//        adjacencyArrayList();
        adjacencyLinkedList();
    }

    public static void adjacencyLinkedList() {
        LinkedList<String> alist = new LinkedList<>(Arrays.asList("A","B","C"));
        LinkedList<String> blist = new LinkedList<>(Arrays.asList("B","D","E"));
        LinkedList<String> clist = new LinkedList<>(Arrays.asList("C","D"));
        LinkedList<String> dlist = new LinkedList<>(Arrays.asList("D","A","D","E"));
        LinkedList<String> elist = new LinkedList<>(Arrays.asList("E"));

        List<LinkedList<String>> graph = new ArrayList<>();
        graph.add(alist);
        graph.add(blist);
        graph.add(clist);
        graph.add(dlist);
        graph.add(elist);

        List<String> edges = new ArrayList<>();
        for(int i=0;i<graph.size();i++){
            LinkedList<String> ll = graph.get(i);
            String startV = ll.get(0);
            for(int j=1;j<ll.size();j++){
                String endV = ll.get(j);
                String edge = null;
                if(startV.equals(endV)){
                    edge = startV+"->"+endV;
                }else{
                    edge = startV+"->"+endV;
                }
                edges.add(edge);
            }
        }
        System.out.println(Arrays.toString(edges.toArray()));
    }

    public static void adjacencyArrayList() {
        //Array
        final List<String> vertices = Arrays.asList("A", "B", "C", "D", "E");
        List<List<String>> graphArrayRepresentation = new ArrayList<>();
        graphArrayRepresentation.add(Arrays.asList("B", "C"));
        graphArrayRepresentation.add(Arrays.asList("D", "E"));
        graphArrayRepresentation.add(Arrays.asList("D"));
        graphArrayRepresentation.add(Arrays.asList("A", "D", "E"));
        //得到Edges
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < vertices.size() && i < graphArrayRepresentation.size(); i++) {//为什么要减去1？不对啊，有可能E到E啊
            String startV = vertices.get(i);
            List<String> endVList = graphArrayRepresentation.get(i);
            if (endVList != null && !endVList.isEmpty()) {
                for (String endV : endVList) {
                    String edge = startV + "->" + endV;
                    edges.add(edge);
                }
            }
        }
        System.out.println(Arrays.toString(edges.toArray()));
    }

    //根据这个matrix求出所有的edges
    public static void incidenceMatrix() {
        final List<String> vertices = Arrays.asList("A", "B", "C", "D", "E");
        final List<String> edgeKeys = Arrays.asList("E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8");

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
        //一行行遍历，先得到1或者-1，然后遍历此列另一个端点，组合成edge
        Map<String, String> edgeMap = new HashMap<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> list = matrix.get(i);
            for (int j = i; j < list.size(); j++) {
                Integer v = list.get(j);
                if (v == 0) {
                    continue;
                } else if (v == 1 || v == -1) {
                    String oneEdge = vertices.get(i);
                    String edgeKey = edgeKeys.get(j);
                    //遍历此列，直到-1，得到endV,如果没有就是自己指向自己的，如DD
                    String twoEdge = null;
                    for (int k = i + 1; k < vertices.size(); k++) {
                        int endV = matrix.get(k).get(j);
                        if (endV + v == 0) {
                            twoEdge = vertices.get(k);
                            break;
                        }
                    }
                    if (v == 1 && twoEdge != null) {
                        edgeMap.put(edgeKey, oneEdge + "->" + twoEdge);
                    } else if (v == -1 && twoEdge != null) {
                        edgeMap.put(edgeKey, twoEdge + "->" + oneEdge);
                    } else if (v == 1 && twoEdge == null) {//所有都是零的话，
                        edgeMap.put(edgeKey, oneEdge + "<->" + oneEdge);
                    }
                }
            }
        }
        System.out.println(edgeMap.toString());
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
