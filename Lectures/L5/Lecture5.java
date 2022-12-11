package L5;

// size and capacity isn't necessary the same length, a list can have a size of 3 but a capacity of 8

class IntArrayList {
    private int[] items; // cap; items.length
    private int size;

    public IntArrayList() {
        items = new int[6];
        size = 0;
    }

    public int getFirst() {
        return items[0];
    }

    public int getLast() {
        return items[size - 1];
    }

    public int size() {
        return size;
    }

    private void grow(int newCap) {
        int[] expandedItem = new int[newCap];
        System.arraycopy(items, 0, expandedItem, 0, size);
        items = expandedItem;
    }

    public void addLast(int val) {
        if (size == items.length) { //full
            grow(size * 2); //multiplying by 2 is faster than +1
        }
        items[size] = val;
        size++;         //since we're adding an element, the size of the list has to increase
    }

    public void removeLast(){
        items[size-1] = 0;
        size--;         //since we're removing an element, the size has to reduce.
    }
    public String toString(){
    String ans = "";
    for (int i=0 ; i<size; i++){
        ans += Integer.toString(items[i]) + ", ";
    }
    return ans;
    }
}
public class Lecture5 {
    public static void main(String[] args) {
        IntArrayList arr = new IntArrayList();
        long start = System.nanoTime();
        for (int i=0;i<7;i++){
            arr.addLast(i+1);
        }
        long end = System.nanoTime();
        System.out.printf("Took %f ms", (end-start)/1e6);
        System.out.print("\n");
        System.out.println(arr);
    }
}
