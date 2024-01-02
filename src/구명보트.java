import java.util.Arrays;

public class 구명보트 {
    static int[] people = {70, 50, 80, 50};
    static int limit = 100;

    public static void main(String[] args) {

        int count = 0;
        int left = 0;
        int right = people.length-1;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                count++;
                right -= 1;
            } else {
                count++;
                right -= 1;
                left ++;
            }
        }
        System.out.println(count);
    }
}
