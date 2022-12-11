package L20;

public interface UndirectedGraph<Vertex> {
    int numEdges();

    int numVertices();

    int deg(Vertex v);

    Iterable<Vertex> adj(Vertex v);

    boolean isEdge(Vertex u, Vertex v);

    void addVertex(Vertex v);

    void addEdge(Vertex u, Vertex v);

    void removeEdge(Vertex u, Vertex v);
}