/**
 * Created by Yubo on 9/17/15.
 *
 */

// The following definitions of Tree and Node are provided.
// insert and delete will be methods of class Tree.

public class BSTModification {
    private class Node {
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;


    /*
     * Please complete this method.
     * Inserts val into the tree. There is no need to rebalance the tree.
     */
    public void insert(int val) {
        if (root == null){
            root = new Node(val);
            return;
        }

        Node pos = findAddPosition(val, root);

        if (pos.val == val) pos.mid = new Node(val);
        else if (pos.val < val) pos.right = new Node(val);
        else pos.left = new Node(val);
    }

    /*
     * Please complete this method.
     * Deletes only one instance of val from the tree.
     * If val does not exist in the tree, do nothing.
     * There is no need to rebalance the tree.
     */
    public void delete(int val) {
        if (root == null){
            return;
        }

        Node pos = findDeletePosition(val, root, null);
        // not in the tree, no operation
        if (pos == null) return;

        // need to delete root, need to check (val == root.val) because
        // findDeletePosition might return root on two cases:
        // (a) root need to be deleted (b) root is the parent of the node that need to be deleted

        if (pos == root && val == root.val && root.mid == null) {
            // need to find new root that doesnt violate ternary search tree
            if (root.right != null && root.left != null){
                // if neither left nor right is null, new root is right,
                // and append root.left and its subtree to the left of the smallest(left most) node under root.right
                Node connection = root.right;

                while (connection.left != null){
                    connection = connection.left;
                }

                connection.left = root.left;
                root = root.right;

            } else if (root.right == null){
                // only right is null
                root = root.left;
            } else {
                // only left is null
                root = root.right;
            }
        }

        // delete a non root node
        if (pos.val == val){
            pos.mid = null;
        } else if (pos.val < val) {
            pos.right = pos.right.right;
            pos.mid = pos.right.mid;
            pos.left = pos.right.left;
        } else {
            pos.right = pos.left.right;
            pos.mid = pos.left.mid;
            pos.left = pos.left.left;
        }

    }

    /*
    * Helper function that find the correct adding position recursively
    * On add, the return value is the Node that is the parent of the value that need to be added
    */
    public Node findAddPosition(int target, Node curr) {

        if (curr.val == target && curr.mid == null) return curr;
        if (curr.val > target && curr.left == null) return curr;
        if (curr.val < target && curr.right == null) return curr;

        if (curr.val == target) {
            return findAddPosition(target, curr.mid);
        }
        else if (curr.val > target) {
            return findAddPosition(target, curr.left);
        }
        else {
            return findAddPosition(target, curr.right);
        }
    }

    /*
    * Helper function that find the correct deleting position recursively
    * On delete, the return value is the parent of the Node that need to be deleted, or null if not found
    */
    public Node findDeletePosition(int target, Node curr, Node parent) {
        // base case: found
        if (curr.val == target && curr.mid == null) return parent == null ? root:parent ;
        // base case: unfound
        if (curr.val > target && curr.left == null) return null;
        if (curr.val < target && curr.right == null) return null;
        // base case: unfound, at leaf
        if (curr.mid == null && curr.left == null && curr.right == null) return null;

        // recursion
        parent = curr;
        if (curr.val == target) {
            return findDeletePosition(target, curr.mid, parent);
        }
        else if (curr.val > target) {
            return findDeletePosition(target, curr.left, parent);
        }
        else {
            return findDeletePosition(target, curr.right, parent);
        }

    }



}
