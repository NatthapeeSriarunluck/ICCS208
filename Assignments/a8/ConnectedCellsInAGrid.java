import java.util.*;

public class ConnectedCellsInAGrid {
    public static int connectedCell(List<List<Integer>> matrix) {
        if (matrix.size() == 0) return 0;
        boolean haveOne = false;
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 1 & bfs(matrix, i, j).size() > count) count = bfs(matrix, i, j).size();
                haveOne = true;
            }
        }
        if (count == 0 && haveOne) {
            return count = 1;
        }
        return count;
    }

    public static List<List<Integer>> nbrs(List<List<Integer>> matrix, Integer i, Integer j) {
        int rowSize = matrix.size();
        int columSize = matrix.get(0).size();
        List<List<Integer>> neighbors = new ArrayList<>();
        //TR
        if (inBoundary(i - 1, j + 1, rowSize, columSize)) {
            if (matrix.get(i - 1).get(j + 1) == 1) neighbors.add(Arrays.asList(i - 1, j + 1));
        }
        // TL
        if (inBoundary(i - 1, j - 1, rowSize, columSize)) {
            if (matrix.get(i - 1).get(j - 1) == 1) neighbors.add(Arrays.asList(i - 1, j - 1));
        }
        //BR
        if (inBoundary(i + 1, j + 1, rowSize, columSize)) {
            if (matrix.get(i + 1).get(j + 1) == 1) neighbors.add(Arrays.asList(i + 1, j + 1));
        }
        //BL
        if (inBoundary(i + 1, j - 1, rowSize, columSize)) {
            if (matrix.get(i + 1).get(j - 1) == 1) neighbors.add(Arrays.asList(i + 1, j - 1));
        }
        //Top
        if (inBoundary(i - 1, j, rowSize, columSize)) {
            if (matrix.get(i - 1).get(j) == 1) neighbors.add(Arrays.asList(i - 1, j));
        }
        //Down
        if (inBoundary(i + 1, j, rowSize, columSize)) {
            if (matrix.get(i + 1).get(j) == 1) neighbors.add(Arrays.asList(i + 1, j));
        }
        //Right
        if (inBoundary(i, j + 1, rowSize, columSize)) {
            if (matrix.get(i).get(j + 1) == 1) neighbors.add(Arrays.asList(i, j + 1));
        }
        //Left
        if (inBoundary(i, j - 1, rowSize, columSize)) {
            if (matrix.get(i).get(j - 1) == 1) neighbors.add(Arrays.asList(i, j - 1));
        }
        return neighbors;
    }

    public static HashSet<List<Integer>> bfs(List<List<Integer>> matrix, Integer row, Integer column) {
        HashSet<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row, column));
        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            List<List<Integer>> neighbors = nbrs(matrix, current.get(0), current.get(1));
            for (List<Integer> neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited;
    }

    public static boolean inBoundary(int row, int column, int rowSize, int columnSize) {
        return row >= 0 && row < rowSize && column >= 0 && column < columnSize;
    }
}