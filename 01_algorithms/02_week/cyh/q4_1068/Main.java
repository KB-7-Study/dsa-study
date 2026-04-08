import java.io.*;
import java.util.*;

public class Main {
    static int N, deleteNode, root;
    static List<Integer>[] children;
    static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 노드 개수 입력
        N = Integer.parseInt(br.readLine());
        children = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        // 2. 부모 정보 입력 및 트리 구조 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i; // 부모가 -1이면 루트 노드
            } else {
                children[parent].add(i); // 부모 리스트에 자식 추가
            }
        }

        // 3. 삭제할 노드 번호 입력
        deleteNode = Integer.parseInt(br.readLine());

        // 예외 처리: 루트를 지우면 남는 리프 노드는 0개
        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        // 4. 루트부터 DFS 탐색 시작
        countLeaf(root);

        System.out.println(leafCount);
    }

    // DFS
    static void countLeaf(int node) {
        int validChildCount = 0;

        for (int child : children[node]) {
            // 삭제될 노드가 아닐 때만 탐색 진행
            if (child != deleteNode) {
                validChildCount++;
                countLeaf(child);
            }
        }

        // 자식이 하나도 없거나, 자식이 있었는데 삭제되어 0이 된 경우 리프 노드
        if (validChildCount == 0) {
            leafCount++;
        }
    }
}