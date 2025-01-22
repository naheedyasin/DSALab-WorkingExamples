package lab12;

public class selectionSort {
    public void sort(int[] arr) {
        int min_index, temp;
        for (int i = 0; i < arr.length; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) min_index = j;
            }
            temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " : ");
        }
    }

    public static void main(String[] args) {
        selectionSort ob = new selectionSort();
        int[] arr = {88, 55, 23, 76, 100, 99};
        ob.sort(arr);
        ob.print(arr);
    }
}
