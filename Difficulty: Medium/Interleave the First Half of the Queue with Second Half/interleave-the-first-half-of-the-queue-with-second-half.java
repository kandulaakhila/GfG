class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        int n=q.size();
        int half=n/2;
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<half;i++){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
        for(int i=0;i<half;i++){
            q.offer(q.poll());
        }
        for(int i=0;i<half;i++){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.offer(stack.pop());
            q.offer(q.poll());
        }
    }
}
