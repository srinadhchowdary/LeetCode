class Solution {
    public List<List<Integer>> generate(int n) {


        List<List<Integer>> l = new ArrayList<>();
        if(n==0)return l;
        List<Integer> fl = new ArrayList<>();
        fl.add(1);
        l.add(fl);
        if(n==1){
            return l;
        }


        for(int i=2;i<=n;i++){
            List<Integer>ll =new ArrayList<>();
            ll.add(1);
            List<Integer>lastlist = l.get(l.size()-1);
            for(int j=0;j<lastlist.size()-1;j++){
                int fir = lastlist.get(j);
                int sec = lastlist.get(j+1);
                ll.add(fir + sec);
            }
            ll.add(1);
            l.add(ll);
        }
        return l;
    }
}