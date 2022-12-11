package Lectures.L16;

 class disjointSets {
    int[] p;
    int[] sz;

    disjointSets(int n) {
        p = new int[n];
        sz = new int[n];
        for (int k = 0; k < n; k++) {
            p[k] = k;
            sz[k] = 1;
        }
    }

    int root(int x) {
        if (p[x] == x) return x;
        else {
            return p[x] = root(p[x]);
        }
    }

    void link(int x, int y) {
        int rx = root(x), ry = root(y);
        if (sz[x] <= sz[y]) {
            p[rx] = ry;
            sz[ry] += sz[rx];
        } else {
            p[ry] = rx;
            sz[rx] += sz[ry];
        }
    }

    boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }
}
public class Lecture16{

}

