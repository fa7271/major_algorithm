public class binarysort {

    public static void main(String[] args) {
        int[] num = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        System.out.println(bin(target, num));
    }

    static int bin(int target, int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int middle = (start+end) / 2;
            if (target == num[middle]) {
                return middle;
            }
            if (num[middle] > target) {
                end = middle - 1;
            }
            if (num[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
}