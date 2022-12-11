package Lectures.L17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


class BinaryHeap<T extends Comparable<? super T>> extends PriorityQueue<T> {
    List<T> entries = new ArrayList<>();// a resizable array for elements
    public BinaryHeap() {
        entries.add(null);
    }
    public BinaryHeap(T[] initArray) {
        Collections.addAll(entries, initArray);
        buildHeap();
    }

    public int size() {
        return entries.size() - 1;
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    private void swp(int i, int j) {
        Collections.swap(entries, i, j);
    }

    private int compare(int i, int j) {
        return entries.get(i).compareTo(entries.get(j));
    }

    public T findMax() {
        return entries.get(1);
    }

    private void swim(int l) {
        while (l > 1 && compare((Integer) parentOf(l), l) < 0) {
            swp((Integer) parentOf(l), l);
            l = (int) parentOf(l);
        }
    }

    public boolean add(T e) {
        entries.add(e);
        swim(this.size());
        return false;
    }

    int parentOf(int k) {
        return k / 2;
    }

    int leftOf(int k) {
        return 2 * k;
    }

    int rightOf(int k) {
        return 2 * k + 1;
    }

    private int maxIndex(int l) {
        int maxDex = leftOf(l), n = this.size();
        if (rightOf(l) <= n &&
                compare(maxDex, rightOf(l)) < 0) {
            maxDex = rightOf(l);
        }
        return maxDex;
    }

    private void sink(int l) {
        int n = this.size();
        while (leftOf(l) <= n) { // not yet a leaf
            int maxDex = maxIndex(l);
            if (compare(l, maxDex) >= 0) {
                break;
            }
            swp(l, maxDex);
            l = maxDex;
        }
    }

    public void removeMax() {
        T lastElt = entries.remove(this.size());
        if (!isEmpty()) {
            entries.set(1, lastElt);
            sink(1);
        }
    }

    private void buildHeap() {
        int n = this.size();
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
    }

    void heapSort(T[] a) {
       BinaryHeap<T> pq = new BinaryHeap<>();
        for (T elt: a) { pq.add(elt); }
        for (int k=a.length-1;k>=0;k--) {
            a[k] = pq.findMax();
            pq.removeMax();
            }
    }

}

public class Lecture17 {
}
