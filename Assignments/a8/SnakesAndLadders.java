import java.util.*;

public class SnakesAndLadders {
    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        HashMap<Integer, Integer> snakeLadderMap = new HashMap<>();
        for (List<Integer> ladder : ladders) snakeLadderMap.put(ladder.get(0), ladder.get(1));
        for (List<Integer> snake : snakes) snakeLadderMap.put(snake.get(0), snake.get(1));
        return bfs(1, snakeLadderMap);
    }

    public static Set<Integer> nbrs(Set<Integer> F, HashMap<Integer,Integer> snakeLadderMap) {
        Set<Integer> nbrSet = new HashSet<>();
        for (Integer num: F) {
            for (int i = num; i <= num + 6; i++) {
                if (!snakeLadderMap.containsKey(num)) {
                    if (snakeLadderMap.containsKey(i)) nbrSet.add(snakeLadderMap.get(i));
                    else {
                        if (!snakeLadderMap.containsKey(i)) nbrSet.add(i);
                    }
                }
            }
        }
        return nbrSet;
    }

    public static int bfs(Integer s, HashMap<Integer, Integer> snakeLadderMap) {
        int count = 0;
        Set<Integer> frontier = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        frontier.add(s);
        visited.add(s);
        while (!frontier.isEmpty()) {
            count++;
            frontier = nbrs(frontier, snakeLadderMap);
            System.out.println(frontier);
            if (frontier.contains(93)) System.out.println(frontier);
            if (frontier.contains(100)) return count;
            frontier.removeAll(visited);
            visited.addAll(frontier);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> ladders = new ArrayList<>();
        List<List<Integer>> snakes = new ArrayList<>();
        ladders.add(Arrays.asList(3,90));
        snakes.add(Arrays.asList(99,10));
        snakes.add(Arrays.asList(97,20));
        snakes.add(Arrays.asList(98,30));
        snakes.add(Arrays.asList(96,40));
        snakes.add(Arrays.asList(95,50));
        snakes.add(Arrays.asList(94,60));
        snakes.add(Arrays.asList(93,70));
        System.out.println(quickestWayUp(ladders,snakes));



    }
}
