public class loadfind {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 5; j++) {
//                1) print(i-1)*5 + j
//                2) 타겟의번호와 타겟의 유효성(2)
//                 -1 타겟의 번호 : i에 1빼면 왼쪽, i에서 1 더하면 오른쪽
//                 -2 타겟의 유효성 : i와 j가 상하좌우 길이 체크

//                상하 좌우 체크 로직.
                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0, -1, 1};
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dx[k];
                    if (1 <= nx && nx <= 3 && 1 <= ny && ny <= 5) {

                    }
                }
            }
        }
    }
}
