class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        TreeMap<Integer,Double> mp = new TreeMap(
            Collections.reverseOrder()
        );

        for(int i=0;i<position.length;i++){
            int pos = position[i];
            double time = (double)(target - pos) / (speed[i]);

            mp.put(pos,time);
        
        }

        double res = 0,curr = 0;

        for(double time : mp.values()){
            if(time > curr){
                curr = time;
                res++;
            }
        }

        return (int)res;
        
    }
}