package com.song.ads.unit3;

/**
 * Created by 001844 on 2018/2/7.
 * Tree sorted,node greater than left sub-tree,less than right sub-tree
 */
public interface Tree<T> {
    void add(T t);

    void delete(Node<T> node);

    void update(Node<T> origin, T t);

    void find(T t);

    String inOrderTraversal();

    String preOrderTraversal();

    String postOrderTraversal();

}
