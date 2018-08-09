package com.song.ads.unit3.graph;

import java.util.*;

/**
 * Created by 001844 on 2018/3/28.
 */
public class GraphTraversal {
    //[A->B, A->C, B->D, B->E, C->D, D->A, D->D, D->E]
    //想想，如果是ABCDE的矩阵，首先得到下方的那个List
    //然后用一个Set保存是否访问过？先取A，然后A的下一个有B或者C，从中取一个B
    //然后B的下一个有D和E，然后顺便那个D，D的下一个有D和E，但是D访问过了，取E
    //E的下一个、。。。如果都访问了，那么继续回溯出栈,
    //草，蛋疼，不怎么会啊
    //关键问题在这里有个递归，如何判断是否还有未访问节点
    public void dfs() {
        Map<String, List<String>> map = new TreeMap<>();
        map.put("A", Arrays.asList("B", "D","E"));
        map.put("B", Arrays.asList("C", "E"));
        map.put("C", Arrays.asList("E","F","G"));
        map.put("D", Arrays.asList("E"));
        map.put("E", Arrays.asList("F"));
        map.put("F",Arrays.asList("G"));

        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if(!visited.contains(key)){
                stack.push(key);
                visited.add(key);
            }
            List<String> val = entry.getValue();
            if(val==null||val.isEmpty()){
                String stackV = stack.pop();
                List<String> val2= map.get(stackV);

            }
            String val2 = val.remove(0);
            if(!visited.contains(key)){
                stack.push(key);
                visited.add(val2);
            }
        }
    }

    /**
     * 他妈的，不对，我曹A,AB,BD,DE,
     * 回溯ED,D,B，如何回溯
     */
}
