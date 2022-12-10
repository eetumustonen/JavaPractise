import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[1000];

        for(int i = 0; i < numbers.length; i++){
           numbers[i] = rand.nextInt(100000);
        }

        System.out.println("Before: ");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter: ");
        printArray(numbers);
    }

    private static void quickSort(int[] numbers, int first, int last) {
        if(first >= last){
            return;
        }
        int pivot = numbers[last];
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        int a = first;
        int b = last;
        for(int i = first; i < last; i++){
            if(numbers[i] < pivot){
                copy[a] = numbers[i];
                a++;
            } else {
                copy[b] = numbers[i];
                b--;
            }
        }
        copy[a] = pivot;
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = copy[i];
        }
        quickSort(numbers, first, a - 1);
        quickSort(numbers, b + 1, last);
    }

    private static void printArray(int[] numbers) {
          for(int i = 0; i < numbers.length; i++){
               System.out.println(numbers[i]);

          }
     }
}
