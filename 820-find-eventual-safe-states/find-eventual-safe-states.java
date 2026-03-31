class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {


        int n = graph.length;
        

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        int indegree[] = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }


        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> safe = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safe.add(node);
            for(Integer it : adjList.get(node)){
                indegree[it] --;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        Collections.sort(safe);
        return safe;


        
    }
}