import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방2 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

//        딕 선언
        HashMap<String, String> dic = new HashMap<>();
        List<String[]> result = new ArrayList<>();

        for (String x : record) {
            String order = x.split(" ")[0];
            String id = x.split(" ")[1];

            if (order.equals("Leave")) {
                result.add(new String[]{id, "님이 나갔습니다."});
            }
            else {
                String name = x.split(" ")[2];
                dic.put(id, name);
                if (order.equals("Enter")) {
                    result.add(new String[]{id, "님이 들어왔습니다."});
                }
            }
        }
        String[] answer = new String[result.size()];
        int idx = 0;
        for (String[] i : result) {
            answer[idx++] = dic.get(i[0]) + i[1];
        }
        System.out.println(Arrays.toString(answer));
    }
}
