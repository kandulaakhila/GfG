/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        // code here Map<Node, Node> parent = new HashMap<>();
        Map<Node, Node> parent = new HashMap<>();
        buildParentMap(root, parent);

        // Step 2: Find target node
        Node targetNode = findTarget(root, target);
        if (targetNode == null) return 0;

        // Step 3: BFS from target node
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        q.add(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean fireSpread = false;
            
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                
                // Spread to left child
                if (node.left != null && visited.add(node.left)) {
                    q.add(node.left);
                    fireSpread = true;
                }
                // Spread to right child
                if (node.right != null && visited.add(node.right)) {
                    q.add(node.right);
                    fireSpread = true;
                }
                // Spread to parent
                if (parent.containsKey(node) && visited.add(parent.get(node))) {
                    q.add(parent.get(node));
                    fireSpread = true;
                }
            }
            
            if (fireSpread) time++;
        }
        
        return time;
    }
    
    // Helper: build parent map
    private void buildParentMap(Node root, Map<Node, Node> parent) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
    
    // Helper: find target node
    private Node findTarget(Node root, int target) {
        if (root == null) return null;
if (root.data == target) return root;
        Node left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }
}