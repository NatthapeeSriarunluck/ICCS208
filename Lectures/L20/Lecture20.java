package Lectures.L20;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lecture20<Vertex>{
    Set<Vertex> nbrs(L20.UndirectedGraph<Vertex> G, Set<Vertex> F) {
        Set<Vertex> nbrSet = new HashSet<>();
        for (Vertex src : F) {
            // function to find adj vertex to the source
            G.adj(src);
            // loop to find all adj vertex
            for (Vertex dst : G.adj(src)) {
                nbrSet.add(dst);
            }
        }
        return nbrSet;
    }

    Set<Vertex> bfs(L20.UndirectedGraph<Vertex> G, Vertex s) {
        Set<Vertex> frontier = new HashSet<>(List.of(s));
        Set<Vertex> visited = new HashSet<>(List.of(s));

        while (!frontier.isEmpty()) {
            // frontier = N(frontier) //adj(frontier)
            frontier = nbrs(G, frontier);
            // frontier = frontier - visited
            frontier.removeAll(visited);
            visited.addAll(frontier);
        }
        return visited;
    }
}
