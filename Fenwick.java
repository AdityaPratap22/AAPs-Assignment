
class FenwickTree {
    private int[] tree;
    public FenwickTree(int n) {
        tree = new int[n + 1]; 
    }
    public void update(int i, int val) {
        while (i < tree.length) {
            tree[i] += val;
            i += i & -i; 
        }
    }
    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= i & -i; 
        }
        return res;
    }
}

public class Fenwick {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        FenwickTree ft = new FenwickTree(arr.length);
        for (int i = 0; i < arr.length; i++) {
            ft.update(i + 1, arr[i]); 
        }

        System.out.println(ft.query(5)); 
    }
}
