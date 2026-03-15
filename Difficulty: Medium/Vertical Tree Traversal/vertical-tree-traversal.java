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
    static class Pair {
        Node node;
        int hd; // horizontal distance
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap keeps keys sorted (HD from leftmost to rightmost)
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;

            // Add node to corresponding HD list
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            // Left child → hd - 1
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            // Right child → hd + 1
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Collect results in order of HD
        for (ArrayList<Integer> list : map.values()) {
            result.add(list);
        }

        return result;
    }
}
