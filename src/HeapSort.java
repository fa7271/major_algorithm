import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HeapSort {
    static int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7};
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        int[] arr1 = {7, 6, 5, 8, 3, 5, 9, 1, 7};
        int n = arr1.length;
//        최초 힙 구성 n /2 번 만큼 heapify 수행
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapfy(arr1, n, i);
        }
//        0 번째와 마지막번째 자리 change 힙정렬
        for (int x = n - 1; x > 0; x--) {
            swap(arr1, 0, x);
            heapfy(arr1, x, 0); // 시작은 8
        }
        System.out.println(Arrays.toString(arr1));
//        최초 힙구성 이후에 root노드와 마지막 노드 체인지
        dfs(arr1, 0);
    }

    private static void dfs(int[] arr1, int i) {
        if (i >= arr1.length) {
            // Leaf node reached, print the path
            for (int j : stack) {
                System.out.print(j);
            }
            System.out.println();
            return;
        }
        stack.add(arr1[i]);  // Add the current node to the path
        // Explore the left child
        if (i * 2 + 1 < arr1.length) {
            dfs(arr1, i * 2 + 1);
        }
        // Explore the right child
        if (i * 2 + 2 < arr1.length) {
            dfs(arr1, i * 2 + 2);
        }
        stack.remove(stack.size() - 1);  // Backtrack: remove the current node from the path
    }


    //
    static void heapfy(int[] arr1, int n, int root) {
//        xx 조건의 경우에 change로직
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int temp = root;
        if (left < n && arr1[left] > arr1[root]) {
            temp = left;
        }
        if (right < n && arr1[right] > arr1[root]) {
            temp = right;
        }

        if (temp != root) {
            swap(arr1, root, temp);
            heapfy(arr1, n, temp);
        }
    }

    private static void swap(int[] arr1, int root, int temp) {
        int x = arr1[root];
        arr1[root] = arr1[temp];
        arr1[temp] = x;
    }
}

