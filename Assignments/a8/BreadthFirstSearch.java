import java.lang.reflect.Array;
import java.util.*;

public class BreadthFirstSearch {


    static class Graph {
        private final HashMap<Integer, HashSet<Integer>> map;

        public Graph() {
            this.map = new HashMap<>();
        }

        public void addVertex(List<Integer> edge) {
            if (!map.containsKey(edge.get(0))) {
                map.put(edge.get(0), new HashSet<>());
            }
            if (!map.containsKey(edge.get(1))) {
                map.put(edge.get(1), new HashSet<>());
            }
        }

        public void addEdge(List<Integer> edge) {
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }

        public Iterable<Integer> adj(Integer v) {
            return map.get(v);
        }
    }

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Graph graph = new Graph();
        for (List<Integer> edge : edges) {
            graph.addVertex(edge);
            graph.addEdge(edge);
        }
        return bfsHelper(graph, n, s);
    }

    public static List<Integer> bfsHelper(Graph G, Integer n, Integer s) {
        Integer[] distance = new Integer[n];
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.fill(distance, -1);
        distance[s - 1] = 0;
        HashSet<Integer> visited = new HashSet<>(List.of(s));
        HashSet<Integer> frontier = new HashSet<>(List.of(s));
        int layer = 1;
        while (!frontier.isEmpty()) {
            frontier = nbrs(G,frontier);
            if (frontier == null) break;
            frontier.removeAll(visited);
            for (Integer i : frontier) {
                distance[i-1] = 6 * layer;
            }
            layer++;
            visited.addAll(frontier);
        }
        for (int i : distance) {
            if (i != 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static HashSet<Integer> nbrs(Graph G, Set<Integer> F) {
        HashSet<Integer> nbrSet = new HashSet<>();
        for (Integer node : F) {
            if (G.adj(node) == null) return null;
            for (Integer dst : G.adj(node)) {
                nbrSet.add(dst);
            }
        }
        return nbrSet;
    }


    public static void main(String[] args) {
        List<List<Integer>> map = new ArrayList<>();
        map.add(Arrays.asList(1, 3));
        map.add(Arrays.asList(3, 4));
        System.out.println(bfs(5, 2, map, 1));
    }
}

