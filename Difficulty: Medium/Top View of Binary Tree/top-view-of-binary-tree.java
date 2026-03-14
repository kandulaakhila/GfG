/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) { node = n; hd = h; }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int minHD = 0, maxHD = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (!map.containsKey(p.hd)) {
                map.put(p.hd, p.node.data);
            }
            minHD = Math.min(minHD, p.hd);
            maxHD = Math.max(maxHD, p.hd);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int hd = minHD; hd <= maxHD; hd++) {
            res.add(map.get(hd));
        }

        return res;
    }
}
