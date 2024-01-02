import java.sql.Array;
import java.util.*;

public class 정수삼각형 {
    static int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    static int[][] dp ;
    public static void main(String[] args) {

        int[][] clone = new int[triangle.length][triangle.length];
        clone[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length-1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
//                 대각
                clone[i + 1][j] = Math.max(clone[i + 1][j], clone[i][j] + triangle[i + 1][j]);
                // 아래
                clone[i + 1][j+1] = Math.max(clone[i + 1][j+1], clone[i][j] + triangle[i + 1][j+1]);
            }
        }

        System.out.println(Arrays.stream(clone[clone.length - 1]).max().getAsInt());
    }
}
