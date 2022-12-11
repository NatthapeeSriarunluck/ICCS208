package Lectures.L20;

import java.util.*;


class UndirectedAdjMap<Vertex> implements L20.UndirectedGraph<Vertex> {
    Map<Vertex, Set<Vertex>> graph;
    int edges;

    public UndirectedAdjMap() {
        this.graph = new HashMap<>();
        this.edges = 0;
    }

    @Override
    public int numEdges() {
        return edges;
    }

    @Override
    public int numVertices() {
        return graph.size();
    }

    @Override
    public int deg(Vertex v) {
        return graph.get(v).size();
    }

    @Override
    public Iterable<Vertex> adj(Vertex v) {
        return graph.get(v);
    }

    @Override
    public boolean isEdge(Vertex u, Vertex v) {
        return graph.get(u).contains(v);
    }

    @Override
    public void addVertex(Vertex v) {
        graph.put(v, new HashSet<>());
    }

    @Override
    public void addEdge(Vertex u, Vertex v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
        edges++;
    }

    @Override
    public void removeEdge(Vertex u, Vertex v) {
        graph.remove(u);
        graph.remove(v);
    }

    public Map<Vertex, Vertex> nbrs(L20.UndirectedGraph<Vertex> G,
                                    Set<Vertex> F) {
        Map<Vertex, Vertex> nbrSet = new HashMap<>();
        for (Vertex src : F) {
            for (Vertex dst : G.adj(src))
                nbrSet.put(dst, src);
        }
        return nbrSet;
    }

    public Map<Vertex, Vertex> bfs(L20.UndirectedGraph<Vertex> G, Vertex s) {
        Map<Vertex, Vertex> frontier = new HashMap<>();
        Map<Vertex, Vertex> visited = new HashMap<>();
        frontier.put(s, null);
        visited.put(s, null);
        while (!frontier.isEmpty()) {
            // frontier = N(frontier) //adj(frontier)
            frontier = nbrs(G, frontier.keySet());
            // frontier = frontier - visited
            frontier.keySet().removeAll(visited.keySet());
            // put in new frontiers into visited
            visited.putAll(frontier);
        }
        return visited;
    }
}

public class BFS<Vertex> {
    static void findShortest(L20.UndirectedGraph<Integer> G, Integer a, Integer b) {
        UndirectedAdjMap<Integer> m = (UndirectedAdjMap<Integer>) G;
        Map<Integer, Integer> aMap = ((UndirectedAdjMap<Integer>) G).bfs(m, b);
        List<Integer> route = new ArrayList<>();
        Integer current = a;
        while (!Objects.equals(current, b)) {
            route.add(current);
            current = aMap.get(current);
        }
        route.add(b);
        for (Integer integer : route) {
            System.out.print(integer + " ");
        }
    }
}
