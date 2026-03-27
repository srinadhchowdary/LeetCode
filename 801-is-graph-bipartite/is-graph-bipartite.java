class Solution {

    public boolean dfs(int node,int col,int[] color,int[][] graph){

        color[node]=col;

        for(Integer it:graph[node]){
            if(color[it] == -1){
                int colo=-1;
                if(col==0)colo=1;
                else colo=0;
                if(dfs(it,colo,color,graph) == false){
                    return false;
                }
            }
            else if(color[it]==col){
                return false;    
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {


        int n=graph.length;
        int m=graph[0].length;

        
        int color[]=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(dfs(i,0,color,graph)== false){
                    return false;
                }
            }
        }
        return true;
    }
}