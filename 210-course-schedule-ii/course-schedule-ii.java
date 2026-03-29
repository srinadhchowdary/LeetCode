class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;

        int ans[] = new int[numCourses];

        if(n == 0){
            for(int i=0;i<numCourses;i++){
                ans[i]=i;
            }
            return ans;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int inorder[]= new int[numCourses];
        for(int i=0;i<n;i++){
            inorder[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inorder[i] == 0){
                q.offer(i);
            }
        }


        int i=0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans[i]=node;
            i++;

            for(Integer it : adjList.get(node)){
                inorder[it]--;
                if(inorder[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(i != numCourses) return new int[0];

        return ans;
        
    }
}