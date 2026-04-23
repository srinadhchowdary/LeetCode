class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n= position.length;
        
        double pair[][] = new double[n][2];

        for(int i=0;i<position.length;i++){
            pair[i][0] = position[i];
            pair[i][1] = (double) (target - position[i])/speed[i];
        }

        Arrays.sort(pair , (a,b) -> Double.compare(b[0],a[0]));
    
        Stack<Double> stk = new Stack<>();


        for(int i=0;i<pair.length;i++){
            double time = pair[i][1];

            if(stk.isEmpty() || time > stk.peek()){
                stk.push(time);
            }

        }

    return stk.size();
       
        
    }
}