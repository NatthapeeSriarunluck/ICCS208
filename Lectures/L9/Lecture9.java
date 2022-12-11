package L9;

public class Lecture9 {
    int fach(int n, int a) {
        if (n == 0) {
            return a;
        }
        return fach(n - 1, a * n);
    }

    int fac(int n) {
        return fach(n, 1);
    }
}
