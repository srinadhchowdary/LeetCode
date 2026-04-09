class Solution {
    public boolean judgeCircle(String moves) {

        int Lmoves=0,Rmoves=0,Umoves=0,Dmoves=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'L')Lmoves++;
            else if(moves.charAt(i) == 'R')Rmoves++;
            else if(moves.charAt(i) == 'U')Umoves++;
            else Dmoves++;
        }
        
        return (Lmoves-Rmoves == 0 && Dmoves-Umoves == 0 ) ? true : false;
    }
}