import java.nio.charset.CodingErrorAction;
import java.sql.Array;
import java.util.*;

public class JourneyToTheMoon {
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        disjointSets countries = new disjointSets(n);
        System.out.println(Arrays.toString(countries.sz));
        for (List<Integer> pair : astronaut) {
            if (!countries.isConnected(pair.get(0), pair.get(1))) {
                countries.link(pair.get(0), pair.get(1));
            }


        }
        HashMap<Integer, Integer> country_size = new HashMap<>();
        for (int country : countries.p) {
            if (!country_size.containsKey(countries.root(country))) {
                country_size.put(countries.root(country), countries.sz[countries.root(country)]);
            }
        }
        long pair = 0L;
        long x = 0L;
        for (int root : country_size.keySet()) {
            int size = country_size.get(root);
            pair += size * x;
            x += size;
        }

        return pair;
    }

    static class disjointSets {
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


    public static void main(String[] args) {
    }
}
