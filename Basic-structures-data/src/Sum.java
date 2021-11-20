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

}
