/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum=0;
    public static void transformTree(Node root) {
        // code here
        sum=0;
        reverseInorder(root);
    }
    public static void reverseInorder(Node node){
        if(node==null) return;
        reverseInorder(node.right);
        int original=node.data;
        node.data=sum;
        sum+=original;
        reverseInorder(node.left);
    }
}