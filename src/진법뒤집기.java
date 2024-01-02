public class 진법뒤집기 {
    public static void main(String[] args) {
        int n = 45;

        String answer = "";

        while (n >= 1) {
            int a = n % 3;
            n /= 3;
            answer += String.valueOf(a);
        }
        int result = 0;
        int k = 1;
        for (int i = answer.length()-1; i >= 0; i--) {
            result += Character.getNumericValue(answer.charAt(i)) * k;

            k *= 3;
        }
        System.out.println(result);
    }
}
