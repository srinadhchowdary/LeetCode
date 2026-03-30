class Solution {

    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adjList , int[] vis,int[] pathvis,int[] check){

        vis[node] = 1;
        pathvis[node] = 1;

        for(Integer it : adjList.get(node)){
            if(vis[it] == 0){
                if(dfs(it,adjList,vis,pathvis,check) == true){
                    return true;
                }
            }
            else if(pathvis[it] == 1){
                return true;
            }
        }   

        pathvis[node] = 0;
        check[node] =1;
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }

        int vis[] = new int[n];
        int pathvis[] = new int[n];
        int check[] = new int[n];


        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,adjList,vis,pathvis,check);
            }
        }

        List<Integer> safe = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i] == 1){
                safe.add(i);
            }
        }

        return safe;
        
    }
}