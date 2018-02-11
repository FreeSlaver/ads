package com.song.ads.unit3.binarytree;

/**
 * Created by 001844 on 2018/2/7.
 */
public class BinaryTreeArrayRepresentation<T> {

    private T[] array;

    public BinaryTreeArrayRepresentation() {
    }
    public BinaryTreeArrayRepresentation(int depth) {
        int size = (int) Math.pow(2,depth);
        this.array = (T[]) new Object[size];
    }

    public static void main(String[] args){

    }
}
