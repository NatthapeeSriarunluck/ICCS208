package Assignments.A2;

/* Collaborator: Achira Laovong 6480154 (It) Pattapon Songpetchmongkol 6380830 (Pete)
In this task, I have explained to  Pete and It how we're supposed to start the front and back pointer of a circular buffer at index 0, knowing this from a video I watched about circular buffer.
I told both to use to modulo function to iterate through the array. Finding the next position of pointer and the next empty position is possible with a formula involving a modulo function. I did
not give them the actual formula, but told them to include modulo in the formulas and follow what is written in the handout as moving the front pointer to the back of the array when we addFirst().

It has helped me to write the shrink() function by explaining that the logic is very similar to the function toString(). He has also helped me on both how to create
a deep copy of an array deque since I was having trouble initialing and working with the syntax of java.
 */
public class ArrayDeque<T> {
    private T[] queue;
    private int front;
    private int back;
    private int size;

    public ArrayDeque() {
        queue = (T[]) new Object[8];
        front = 0;
        back = 0;
        size = 0;
    }

    public ArrayDeque(ArrayDeque<T> other) {

        T[] copy = (T[]) new Object[other.queue.length];
        queue = copy;
        front = other.front;
        size = other.size;
        back = other.back;
        System.arraycopy(other.queue, 0, copy, 0, other.queue.length);
    }

    public void addFirst(T item) {
        if (size == queue.length) {
            T[] copy = (T[]) new Object[this.queue.length * 2];
            int newfront = copy.length - (queue.length);
            System.arraycopy(this.queue, 0, copy, newfront, (queue.length));
            this.queue = copy;
            front = newfront;
        }
        front = (front + queue.length - 1) % queue.length;
        queue[front] = item;
        size++;

    }

    public void addLast(T item) {
        if (size == queue.length) {
            T[] copy = (T[]) new Object[this.queue.length * 2];
            System.arraycopy(this.queue, 0, copy, 0, size);
            this.queue = copy;
        }
        if (front != back) {
            back = back % queue.length;
        }
        queue[back] = item;
        back++;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String ans = "";
        int i = front;
        int count = 0;
        while (queue[i] != null && count < queue.length) {
            ans += queue[i].toString() + " ";
            i = (i + 1) % queue.length;
            count++;
        }
        return ans;
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (queue.length >= 16 && size <= queue.length * 0.25) {
            shrink();
        }
        T removed = queue[front];
        queue[front] = null;
        front++;
        size--;
        return removed;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (queue.length >= 16 && size <= queue.length * 0.25) {
            shrink();
        }
        T removed = queue[(size + front - 1) % queue.length];
        queue[(size + front - 1) % queue.length] = null;
        if (front != back) {
            back = back % queue.length;
        }
        size--;
        back++;
        return removed;
    }

    public T get(int index) {
        return queue[(front + index) % queue.length];
    }

    public void shrink() {
        T[] copy = (T[]) new Object[queue.length / 2];
        int i = front;
        int count = 0;
        while (queue[i] != null && count < queue.length) {
            copy[count] = queue[i];
            i = (i + 1) % queue.length;
            count++;
        }
        this.queue = copy;
        front = 0;
        back = i;
    }


}
