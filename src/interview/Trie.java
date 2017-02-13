package interview;

import util.TrieNode;

/**
 * Created by pengshuang on 17/2/13.
 * 字典树(前缀树)的实现
 *
 * void insert(String word): 添加word,可重复添加
 * void delete(String word): 删除word,如果word添加过多次,仅删除一个
 * boolean search(String word): 查询word是否在字典树中
 * int prefixNumber(String pre): 返回以字符串pre为前缀的单词数量
 */

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
    }

}
