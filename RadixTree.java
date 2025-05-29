import java.util.*;

class RadixNode {
    Map<String, RadixNode> children;
    boolean isEnd;

    RadixNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

public class RadixTree {
    private RadixNode root;

    public RadixTree() {
        root = new RadixNode();
    }

    private String commonPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLen && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    public void insert(String word) {
        RadixNode node = root;
        String currentWord = word;

        while (!currentWord.isEmpty()) {
            boolean foundPrefix = false;
            for (Map.Entry<String, RadixNode> entry : node.children.entrySet()) {
                String key = entry.getKey();
                String common = commonPrefix(key, currentWord);

                if (!common.isEmpty()) {
                    foundPrefix = true;
                    if (common.equals(key)) {
                        currentWord = currentWord.substring(common.length());
                        node = entry.getValue();
                        break;
                    } else if (common.equals(currentWord)) {
                        RadixNode oldChild = node.children.get(key);
                        node.children.remove(key);
                        RadixNode newNode = new RadixNode();
                        newNode.children.put(key.substring(common.length()), oldChild);
                        newNode.isEnd = true;
                        node.children.put(common, newNode);
                        return;
                    } else {
                        RadixNode oldChild = node.children.get(key);
                        node.children.remove(key);
                        RadixNode newNode = new RadixNode();
                        newNode.children.put(key.substring(common.length()), oldChild);
                        RadixNode newChild = new RadixNode();
                        newChild.isEnd = true;
                        newNode.children.put(currentWord.substring(common.length()), newChild);
                        node.children.put(common, newNode);
                        return;
                    }
                }
            }
            if (!foundPrefix) {
                RadixNode newNode = new RadixNode();
                newNode.isEnd = true;
                node.children.put(currentWord, newNode);
                return;
            }
        }
    }

    public boolean search(String word) {
        RadixNode node = root;
        String currentWord = word;

        while (!currentWord.isEmpty()) {
            boolean found = false;
            for (Map.Entry<String, RadixNode> entry : node.children.entrySet()) {
                String key = entry.getKey();
                if (currentWord.startsWith(key)) {
                    currentWord = currentWord.substring(key.length());
                    node = entry.getValue();
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        RadixTree tree = new RadixTree();
        tree.insert("rom");
        tree.insert("rope");
        tree.insert("rose");
        tree.insert("road");

        System.out.println(tree.search("rom"));    
        System.out.println(tree.search("rope"));   
        System.out.println(tree.search("rose"));   
        System.out.println(tree.search("ro"));     
        System.out.println(tree.search("roar"));   
    }
}
