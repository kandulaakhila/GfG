/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int ans = Integer.MIN_VALUE;

        public int maxDiff(Node root) {
            findMin(root);
            return ans;
        }

        int findMin(Node root) {

            if (root == null)
                return Integer.MAX_VALUE;

            int left = findMin(root.left);

            int right = findMin(root.right);

            int minDesc = Math.min(left, right);

            if (minDesc != Integer.MAX_VALUE) {
                ans = Math.max(ans,
                        root.data - minDesc);
            }

            return Math.min(root.data, minDesc);
        }
    }