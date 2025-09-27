/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node zerod=new Node(0),oned=new Node(0),twod=new Node(0);
        Node zero=zerod,one=oned,two=twod;
        Node curr=head;
        while(curr!=null){
            if(curr.data==0){
                zero.next=curr;
                zero=zero.next;
            }
            else if(curr.data==1){
                one.next=curr;
                one=one.next;
            }else{
                two.next=curr;
                two=two.next;
            }
            curr=curr.next;
        }
        zero.next=(oned.next!=null)?oned.next:twod.next;
        one.next=twod.next;
        two.next=null;
        return zerod.next;
    }
}