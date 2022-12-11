package Lectures.L17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueue<T> {
    Comparator<T> cc;
    List<T> entries = new ArrayList<>();

    public MyPriorityQueue(Comparator<T> cc) {
        this.cc = cc;
        entries.add(null);
    }

    public int size() {
        return entries.size() - 1;
    }

    public boolean isEmpty() {
        return 0 == size();
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

    private void swp(int i, int j) {
        Collections.swap(entries, i, j);
    }

    private int compare(int i, int j) {
        return cc.compare(entries.get(i), entries.get(j));
    }

    public T findMax() {
        return entries.get(1);
    }

    private void swim(int l) {
        while (l > 1 && compare(parentOf(l), l) < 0) {
            swp((Integer) parentOf(l), l);
            l = (int) parentOf(l);
        }
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

    public boolean add(T e) {
        entries.add(e);
        swim(this.size());
        return false;
    }

    private int maxIndex(int l) {
        int maxDex = leftOf(l), n = this.size();
        if (rightOf(l) <= n &&
                compare(maxDex, rightOf(l)) < 0) {
            maxDex = rightOf(l);
        }
        return maxDex;
    }


    public void removeMax() {
        T lastElt = entries.remove(this.size());
        if (!isEmpty()) {
            entries.set(1, lastElt);
            sink(1);
        }
    }
}

