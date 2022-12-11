package L15;//Reference: Coding with John

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Lecture15 {
    static <T> void insertionSort(T[] array, Comparator<T> cc) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && cc.compare(array[j], key) >= 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    static <T> void mergeInto(T[] a, T[] b, T[] out, Comparator<T> cc) {
        int i = 0, j = 0;
        for (int o = 0; o < out.length; o++) {
            if (i >= a.length)
                out[o] = b[j++];
            else if (j >= b.length)
                out[o] = a[i++];
            else if (cc.compare(a[i], b[j]) <= 0)
                out[o] = a[i++];
            else out[o] = b[j++];
        }
    }

    static <T> void mergeSort(T[] a, Comparator<T> cc) {
        int n = a.length;
        if (n <= 1) return;
        T[] left = Arrays.copyOfRange(a, 0, n / 2);
        T[] right = Arrays.copyOfRange(a, n / 2, n);
        mergeSort(left, cc);
        mergeSort(right, cc);
        mergeInto(left, right, a, cc);
    }


    static <T> void quicksort(T[] array, Comparator<T> cc) {
        quicksort(array, 0, array.length - 1, cc);
    }

    static <T> void quicksort(T[] array, int lowIndex, int highIndex, Comparator<T> cc) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot, cc);

        quicksort(array, lowIndex, leftPointer - 1, cc);
        quicksort(array, leftPointer + 1, highIndex, cc);

    }

    static <T> int partition(T[] array, int lowIndex, int highIndex, T pivot, Comparator<T> cc) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            while (cc.compare(array[leftPointer], pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (cc.compare(array[rightPointer], pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        if (cc.compare(array[leftPointer], array[highIndex]) >= 0) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Comparator<Integer> cc = Integer::compareTo;

        Integer[] test = {1, 5, 6, 4, 7};
        quicksort(test, cc);
        System.out.println(Arrays.toString(test));
    }
}
