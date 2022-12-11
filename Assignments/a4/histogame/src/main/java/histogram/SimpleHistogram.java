package histogram;

import java.util.*;

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {
    private final HashMap<DT, Integer> hash;

    public SimpleHistogram() {
        this.hash = new HashMap<>();
    }

    public SimpleHistogram(DT[] items) {
        this.hash = new HashMap<>();
        for (DT i : items) {
            hash.merge(i, 1, Integer::sum);
        }
    }

    public SimpleHistogram(Histogram<DT> hist) {
        this.hash = new HashMap<>();
        for (DT i : hist) {
            hash.put(i, hist.getCount(i));
        }
    }
    @Override
    public int getTotalCount() {
        Integer count = 0;
        for (Map.Entry<DT, Integer> entry : hash.entrySet()) {
            Integer value = entry.getValue();
            count += value;
        }
        return count;
    }

    @Override
    public int getCount(DT item) {
        Integer count = 0;
        if (hash.containsKey(item)) {
            count += hash.get(item);
        } else {
            return 0;
        }
        return count;
    }

    @Override
    public void setCount(DT item, int count) {
        hash.put(item, count);
    }

    public int size() {
        return hash.size();
    }

    public HashMap<DT, Integer> getHash() {
        return hash;
    }

    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<DT, Integer> entry : hash.entrySet()) {
            DT domain = entry.getKey();
            Integer frequency = entry.getValue();
            ans.append(" ").append(domain).append(":").append(frequency);
        }
        return ans.toString();
    }

    @Override
    public Iterator<DT> iterator() {
        return new SimpleHistogramIterator();
    }

    class SimpleHistogramIterator implements Iterator<DT> {
        private int count;
        private final Set<DT> keySet = hash.keySet();
        private final ArrayList<DT> keyList = new ArrayList<DT>(keySet);

        public SimpleHistogramIterator() {
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < keyList.size();
        }

        @Override
        public DT next() {
            if (hasNext()) {
                return keyList.get(count++);
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }  // Check (1) and (2)
        if (this == o) {
            return true;
        } //Speed up the case

        SimpleHistogram<DT> other = (SimpleHistogram<DT>) o;
        if (this.hash.size() != other.hash.size()) {
            return false;
        }

        for (DT item : (DT[]) this.hash.keySet().toArray()) {
            if (!other.hash.containsKey(item)) {
                return false;
            } else if (!other.hash.get(item).equals(this.hash.get(item))) {
                return false;
            }
        }
        return true;
    }

}

