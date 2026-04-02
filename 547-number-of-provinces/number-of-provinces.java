class Solution {

    public void dfs(int node,int vis[],ArrayList<ArrayList<Integer>> adj){

        vis[node] =1;
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {


        int v = isConnected.length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }

        int vis[]=new int[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(vis[i] == 0){
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
}