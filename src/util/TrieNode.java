package util;

/**
 * Created by pengshuang on 17/2/13.
 * path 表示有多少个单词共用这个节点
 * end 表示由多少个单词以这个节点结尾
 * map 是一个哈希表结构, key 代表该节点的一条字符路径, value 表示字符路径指向的节点
 */

public class TrieNode {
    public int path;
    public int end;
    public TrieNode[] map;

    public TrieNode() {
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }
}
