package org.example.BinarySearchTrees;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {9,5,7,12,15,3,2};
        tree.populate(nums);
        //tree.populateSorted(nums);
        System.out.println("Level order success of 3 :"+tree.levelOrderSuccessor(9));
        System.out.println(tree.BFS());
        System.out.println("Level Average :"+tree.averageOfLevels());
        System.out.println(5.0+6);
        tree.display();
        List<Integer> ls;



  /*      AVLTree avlTree = new AVLTree();
        for(int i = 3; i>0; i--){
            avlTree.insert(i);
        }
        System.out.println(avlTree.height(avlTree.root)); */

       // int[] arr = {5,8,6,24,1,3,8};
       /* int[] arr = {8,6,-2,8,3,5,9,7};
        SegmentTree segmentTree = new SegmentTree(arr);
        int resultsum = segmentTree.querySum(1,5);
        System.out.println(resultsum);
        System.out.println("The total no of counts :"+SegmentTree.count);*/
    }
}
