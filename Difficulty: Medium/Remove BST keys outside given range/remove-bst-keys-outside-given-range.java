/*
class Node
/* class Node { 
int data;
Node left;
Node right;
Node(int data){
    this.data = data; 
    left=null; right=null;
}
} */
class Solution { Node removekeys(Node root, int l, int r) {
    // code here
    if(root==null) return null;
    //if root's data is less than l discard left subtree
    if(root.data<l){
        return removekeys(root.right,l,r);
    }
    //if root's data greater than r,discard right subtree
    if(root.data>r){
        return removekeys(root.left,l,r);
    }
    //otherwise trim both subtrees
    root.left=removekeys(root.left,l,r);
    root.right=removekeys(root.right,l,r);
    return root;
}




}
