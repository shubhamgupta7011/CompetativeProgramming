import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void display( int[] arr){
        for (Integer integer : arr) {
            System.out.print(integer + ",");
        }
    }
}

class MergeSort {
    public static List<Integer> arr1;

    public static List<Integer> merge(List<Integer> leftArr, List<Integer> rightArr) {
        List<Integer> arr = new ArrayList<>(leftArr.size() + rightArr.size());
        int i = 0, j = 0;
        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i) > rightArr.get(j)) {
                arr.add(rightArr.get(j));
                j++;
            } else if (leftArr.get(i) < rightArr.get(j)) {
                arr.add(leftArr.get(i));
                i++;
            }
        }
        while (i < leftArr.size()) { arr.add(leftArr.get(i)); i++; }
        while (j < rightArr.size()) { arr.add(rightArr.get(j)); j++;}
        return arr;
    }

    public static List<Integer> mergeSort(List<Integer> arr, int leftPoint, int rightPoint) {
        if (leftPoint < rightPoint) {
            int mid = (leftPoint + rightPoint) / 2;
            List<Integer> left = mergeSort(arr, leftPoint, mid);
            List<Integer> right = mergeSort(arr, mid + 1, rightPoint);
            return arr1 = merge(left, right);
        }
        return arr.subList(leftPoint,rightPoint+1);
    }

    public static void display( List<Integer> arr){
        for (Integer integer : arr) {
            System.out.print(integer + ",");
        }
    }

}

public class SortingAlgo {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(38, 27, 43, 3, 9, 82, 10);
        arr = MergeSort.mergeSort(arr, 0, arr.size() - 1);
        MergeSort.display(arr);
    }

}
