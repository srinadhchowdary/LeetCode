class Pair{
    String code;
    String businessLine;

    Pair(String code , String businessLine){
        this.code = code;
        this.businessLine = businessLine;
    }
}

class Solution {

    public boolean ValidBusiness(String busineessLine){

        if(busineessLine.equals("electronics") || busineessLine.equals("grocery") || busineessLine.equals("pharmacy")
        || busineessLine.equals("restaurant")){
            return true;
        }
        return false;
    }

    public boolean isValid(String code){

        if(code == null || code.isEmpty()){return false;}

        for(int i=0;i<code.length();i++){
            char ch = code.charAt(i);

            if(Character.isLetterOrDigit(ch) || ch == '_' ){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        int n= code.length;

        List<Pair> p=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isValid(code[i]) && ValidBusiness(businessLine[i]) && isActive[i]){
                p.add(new Pair(code[i],businessLine[i]));
            } 
        }
        p.sort((a,b)->{
            int res=a.businessLine.compareTo(b.businessLine);
            if(res==0)
                return a.code.compareTo(b.code);
            return res;
        });

        List<String> l = new ArrayList<>();
        for(Pair curr:p)
            l.add(curr.code);
        return l;
    }
}