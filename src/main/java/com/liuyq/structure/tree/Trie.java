package com.liuyq.structure.tree;

/**
 * @author liuyuqing
 * @className Trie
 * @description 用于存储查找推荐
 * @date 2022/1/18 2:04 下午
 */
public class Trie {
    private TrieNode root = new TrieNode('/');


    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] patten) {
        TrieNode p = root;
        for (int i = 0; i < patten.length; i++) {
            int index = patten[i] - 'a';
            // 没有匹配
            if (p.children[index] == null) {
                return false;
            }
            //下一个字符存在节点的子节点链里面
            p = p.children[index];
        }
        if (p.isEndingChar) {
            // 完全匹配
            return true;
        } else {
            // 没有完全匹配
            return false;
        }
    }


    public class TrieNode {
        char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        TrieNode(char data) {
            this.data = data;
        }

    }

    public static void main(String[] agrs) {
        Trie trie = new Trie();

        trie.insert("lo".toCharArray());
        trie.insert("le".toCharArray());

        System.out.println(trie);
    }
}
