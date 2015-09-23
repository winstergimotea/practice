package practice;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by winster on 5/1/14.
 */
public class ArrayUtils {
    public <T extends Comparable<T>> void selectionSort(T[] array) {
        for(int i=0; i<array.length-1; i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[i].compareTo(array[j]) > 0)
                    swap(array, i, j);
            }
        }
    }

    public <T extends Comparable<T>> void bubbleSort(T[] array) {
        boolean hasSwap = true;
        while (hasSwap) {
            hasSwap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    hasSwap = true;
                }
            }
        }
    }

    public <T extends Comparable<T>> void insertionSort(T[] array) {
        for(int i=0; i<array.length-1; i++) {
            for(int j=i+1; j>0 && array[j].compareTo(array[j-1]) > 0; j--) {
                swap(array, j, j-1);
            }
        }
    }

    public <T extends Comparable<T>> void mergeSort(T[] array) {
        if(array.length > 1) {
            int min = 0, max = array.length, mid = (min + max) / 2;
            T[] left = Arrays.copyOfRange(array, 0, mid);
            T[] right = Arrays.copyOfRange(array, mid, max);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    public <T extends Comparable<T>> void merge(T[] merged, T[] left, T[] right) {
        int lIdx = 0, rIdx = 0;
        int length = merged.length;
        for(int mIdx=0; mIdx<length; mIdx++) {
            if(lIdx<length && rIdx<length && mIdx<length) {
                merged[mIdx] = left[lIdx].compareTo(right[rIdx]) >= 0 ? left[lIdx++] : right[rIdx++];
            } else {
                merged[mIdx] = lIdx<length ? left[lIdx++] : right[rIdx++];
            }
        }
    }

    public <T extends Comparable<T>> void quickSort(T[] array) {
        if(array.length<2)
            return;

        int from=0, to=array.length;
        quickSort(array, from, to);
    }

    public <T extends Comparable<T>> void quickSort(T[] array, int from, int to) {
        if(from!=to) {
            int pIndex = partition(array, from, to);
            quickSort(array, from, pIndex);
            quickSort(array, pIndex, to);
        }
    }

    public <T extends Comparable<T>> int partition(T[] array, int from, int to) {
        int pIndex = (new Random()).nextInt((from - to)) + from;
        for(int i=from; i<to; i++) {
            if(i<pIndex && array[i].compareTo(array[pIndex]) >= 0) {
                swap(array, i, pIndex--);
            } else if(i>pIndex && array[i].compareTo(array[pIndex]) < 0) {
                swap(array, i, pIndex++);
            }
        }
        return pIndex;
    }


    <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
