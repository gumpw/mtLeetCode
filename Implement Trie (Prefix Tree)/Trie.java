import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Implement a trie with insert, search, and startsWith methods.
   Note:
        You may assume that all inputs are consist of lowercase letters a-z..
 * </p>
 *
 * Trie树的三个特性:
 * 根节点不包含字符，除根节点外每一个节点都只包含一个字符;
 * 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串;
 * 每个节点的所有子节点包含的字符都不相同。
 *
 * o-a
 * |\
 * c b
 * @author Magic Joey
 * @version Trie.java 1.0 @2015/6/23 17:37 $
 */
class TrieNode {

    boolean wordsEnding = false;
    // Initialize your data structure here.
    Map<Character,TrieNode> dataMap = new HashMap<Character,TrieNode>(26*3/2);

    public TrieNode() {
    }

}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode prefix = null;
        TrieNode current = null;
        //判断是否需要新增
        for(int i=0;i<charArray.length;i++){

            if(i==0){
                current = root.dataMap.get(charArray[0]);
                prefix = root;
            }
            if(i!=0) {
                prefix = current;
                current = current.dataMap.get(charArray[i]);
            }
            if(i==charArray.length-1&&current!=null){
                current.wordsEnding = true;
            }
            if(current==null){
                TrieNode trieNode = new TrieNode();
                if(i==charArray.length-1){
                   trieNode.wordsEnding = true;
                }
                prefix.dataMap.put(charArray[i],trieNode);

                current = prefix.dataMap.get(charArray[i]);
            }
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] charArray = word.toCharArray();

        TrieNode trieNode = null;
        //判断是否需要新增
        for(int i=0;i<charArray.length;i++) {

            if (i == 0) {
                trieNode = root.dataMap.get(charArray[i]);
            } else {
                trieNode = trieNode.dataMap.get(charArray[i]);
            }
            if(trieNode==null){
                return false;
            }
        }
        return trieNode.wordsEnding;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();

        TrieNode trieNode = null;
        //判断是否需要新增
        for(int i=0;i<charArray.length;i++) {

            if (i == 0) {
                trieNode = root.dataMap.get(charArray[i]);
            } else {
                trieNode = trieNode.dataMap.get(charArray[i]);
            }
            if(trieNode==null){
                return false;
            }
        }
        return true;
    }

}
