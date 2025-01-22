package lab13;

public class BubbleSort {

    void bubbleSort(int numbers[], int array_size){
        int i, j, temp;

        for (i = (array_size - 1); i>= 0; i--)
            for (j = 1; j <= i; j++)
                if (numbers[j-1] > numbers[j]){
                    temp = numbers[j-1];
                    numbers[j-1] = numbers[j]; numbers[j] = temp;
            }
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {67, 44, 82, 17, 20};

        System.out.print("Array before Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();

        for(int i = 0; i<n; i++) {
            int swaps = 0;

            for(int j = 0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp;
                    temp = arr[j]; arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps = 1;
                }
            }
            if(swaps == 0)
                break;
        }

        System.out.print("Array After Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}