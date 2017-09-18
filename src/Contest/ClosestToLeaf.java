package Contest;

/**
 * Created by pengshuang on 17/9/18.
 */

class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class ClosestToLeaf {
    // A utility function to find minimum of x and y
    int getMin(int x, int y)
    {
        return (x < y) ? x : y;
    }

    // A utility function to find distance of closest leaf of the tree
    // rooted under given root
    int closestDown(Node node)
    {
        // Base cases
        if (node == null)
            return Integer.MAX_VALUE;
        if (node.left == null && node.right == null)
            return 0;

        // Return minimum of left and right, plus one
        return 1 + getMin(closestDown(node.left), closestDown(node.right));
    }

    // Returns distance of the cloest leaf to a given key 'k'.  The array
    // ancestors is used to keep track of ancestors of current node and
    // 'index' is used to keep track of curremt index in 'ancestors[]'
    int findClosestUtil(Node node, char k, Node ancestors[], int index)
    {
        // Base case
        if (node == null)
            return Integer.MAX_VALUE;

        // If key found
        if (node.data == k)
        {
            //  Find the cloest leaf under the subtree rooted with given key
            int res = closestDown(node);

            // Traverse all ancestors and update result if any parent node
            // gives smaller distance
            for (int i = index - 1; i >= 0; i--)
                res = getMin(res, index - i + closestDown(ancestors[i]));
            return res;
        }

        // If key node found, store current node and recur for left and
        // right childrens
        ancestors[index] = node;
        return getMin(findClosestUtil(node.left, k, ancestors, index + 1),
                findClosestUtil(node.right, k, ancestors, index + 1));

    }

    // The main function that returns distance of the closest key to 'k'. It
    // mainly uses recursive function findClosestUtil() to find the closes
    // distance.
    int findClosest(Node node, char k)
    {
        // Create an array to store ancestors
        // Assumptiom: Maximum height of tree is 100
        Node ancestors[] = new Node[100];

        return findClosestUtil(node, k, ancestors, 0);
    }
}
