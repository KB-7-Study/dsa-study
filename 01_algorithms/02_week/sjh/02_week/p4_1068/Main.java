import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int root, deleteNode, leafCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) root = i;
            else tree[parent].add(i);
        }
        deleteNode = sc.nextInt();

        if (deleteNode == root) System.out.println(0);
        else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    static void dfs(int node) {
        int children = 0;
        for (int next : tree[node]) {
            if (next != deleteNode) {
                children++;
                dfs(next);
            }
        }
        if (children == 0) leafCount++;
    }
}