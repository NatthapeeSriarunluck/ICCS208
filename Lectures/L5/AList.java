package L5;
/*
To answer the question to how long it'll take to addFirst(), it will take linear time dependent on the size of the array.
Since we need to System.arraycopy the original list to the new list every time we addFirst().
*/

public class AList<T> {
    private T[] items; // cap; items.length
    private int size;
    @SuppressWarnings("unchecked")
    public AList() {
        items = (T[]) new Object[4];
        size = 0;
    }
    @SuppressWarnings("unchecked")
    public void addFirst(T x) {
        T[] copy = (T[]) new Object[size+1];
        copy[0] = x;
        System.arraycopy(items, 0, copy, 1, size);
        items = copy;
        size++;
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans += items[i] + ", ";
        }
        return ans;
    }

    public T removeLast() {
        T itemToRemove = items[size - 1];
        items[size - 1] = null;
        size--;

        return itemToRemove;
    }
}

