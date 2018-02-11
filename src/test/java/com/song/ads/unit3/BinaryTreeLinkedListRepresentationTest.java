package com.song.ads.unit3;

import com.song.ads.unit3.binarytree.BinaryTreeLinkedListRepresentation;
import org.junit.Test;

/**
 * Created by 001844 on 2018/2/7.
 */
public class BinaryTreeLinkedListRepresentationTest {

    @Test
    public void test(){
        BinaryTreeLinkedListRepresentation tree = new BinaryTreeLinkedListRepresentation();
        String inOrderTraversal = tree.inOrderTraversal();
        String preOrderTraversal = tree.preOrderTraversal();
        String postOrderTraversal = tree.postOrderTraversal();
    }
}
