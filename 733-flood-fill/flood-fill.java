class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row =row;
        this.col=col;
    }
}
class Solution {

    public void bfs(int i,int j,int[][] vis,int[][]image,int original,int color,int n,int m){

        vis[i][j]=1;
        image[i][j]=color;

        
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(i,j));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row= p.row;
            int col = p.col;

            int delrow[]={-1,0,+1,0};
            int delcol[]={0,-1,0,+1};

            for(int x=0;x<4;x++){
                int nrow = row+delrow[x];
                int ncol = col+delcol[x];

                if(nrow>=0 && ncol >=0 && nrow<n && ncol<m && vis[nrow][ncol] == 0 && image[nrow][ncol] == original){
                    image[nrow][ncol]=color;
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n=image.length;
        int m= image[0].length;

        int vis[][]=new int[n][m];

        int original= image[sr][sc];

        if(original == color)return image;

        bfs(sr,sc,vis,image,original,color,n,m);

        
    return image;  
    }
}