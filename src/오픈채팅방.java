import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

//        딕 선언
        HashMap<String, String> dic = new HashMap<>();
        List<String> result = new ArrayList<>();
//        가장 마지막으로 쓰이는 아이디로 최신화
        for (String s : record) {
            String[] re = s.split(" ");
            if (re.length >= 3) {
                dic.put(re[1], re[2]);
            }
        }

        for (String s : record) {
            String[] res = s.split(" ");
            if (res[0].equals("Enter")) {
                result.add(dic.get(res[1]) + "님이 들어왔습니다.");
            }
            else if(res[0].equals("Leave")){
                result.add(dic.get(res[1]) + "님이 나갔습니다.");
            }
        }
        System.out.println(result.toArray(new String[result.size()]));
    }
}
