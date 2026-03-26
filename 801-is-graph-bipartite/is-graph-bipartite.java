class Solution {
    public boolean check(int start , int[] color,int[][] graph){
        Queue<Integer> q= new LinkedList<>();
        q.offer(start);

        color[start]=0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it:graph[node]){
                if(color[it]==-1){
                    if(color[node] == 1){color[it]=0;}
                    else{color[it]=1;}
                    q.offer(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
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
                if(check(i,color,graph)== false){
                    return false;
                }
            }
        }
        return true;
    }
}