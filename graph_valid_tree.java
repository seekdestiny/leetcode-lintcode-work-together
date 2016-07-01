//method 1: BFS
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);      
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        queue.add(0);
        set.add(0);
        
        int cnt = n;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int item: graph.get(temp)) {
                if (!set.contains(item)) {
                    queue.add(item);
                    set.add(item);
                    graph.get(item).remove(temp);
                } else {
                    return false;
                }
            }
            cnt--;
        }
        
        return cnt == 0;
    }
}
