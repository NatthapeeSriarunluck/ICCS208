public class OffByN implements CharacterComparator {
    int val;

    public OffByN(int N) {
        this.val = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == val) || (x - y == -val);
    }
}