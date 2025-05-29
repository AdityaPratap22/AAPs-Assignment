import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean end;

    public TrieNode() {
        children = new HashMap<>();
        end = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.end;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"apple", "app", "bat", "ball"};

        for (String word : words) {
            trie.insert(word);
        }

        System.out.println(trie.search("app")); 
        System.out.println(trie.search("bat")); 
        System.out.println(trie.search("bats")); 
    }
}
