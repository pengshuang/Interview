package interview;

import util.Node;
import util.Node2;

/**
 * Created by pengshuang on 17/2/14.
 * 统计完全二叉树的节点数
 */

public class NodeNum {

    public int nodeNum(Node2 head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public int bs(Node2 node, int l, int h) {
        if (l == h) {
            return l;
        }
        if (mostLeftLevel(node.right, l + 1) == h) {
            return (1 << (h - 1)) + bs(node.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    public int mostLeftLevel(Node2 node, int level) {
        while (node != null) {
            level ++;
            node = node.left;
        }
        return level - 1;
    }
}
