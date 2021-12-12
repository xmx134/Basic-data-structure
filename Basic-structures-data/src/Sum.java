public class Sum {
    public static int sum(int[] arr){
        return sum(arr, 0);
    }
    private static int sum(int[] arr, int l){
        if(arr.length == l) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    int max(int[] arr, int l, int max) {
        if (arr.length == l) {
            return max;
        }
        return arr[l] > max(arr, l + 1, max) ? arr[l] : max(arr, l + 1 , max);
    }

    int binaryChop(int[] arr, int min, int max, int target) {
        int cur = (min + max) / 2;
        if (arr[cur] == target) {
            return cur;
        } else if (arr[cur] < target) {
            return binaryChop(arr, min, cur, target);
        } else if (arr[cur] > target) {
            return binaryChop(arr, cur, max, target);
        }
        return -1;
    }

}
