class Pair{
    String word;
    int steps;
    Pair(String word,int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int len = wordList.size();
        
        if(beginWord.equals(endWord))return 1;

        Set<String> s = new HashSet<>();
        for(int i=0;i<len;i++){
            s.add(wordList.get(i));
        }

        if(!s.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        s.remove(beginWord);
        while(!q.isEmpty()){

            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char words[] = word.toCharArray();
                    words[i]=ch;
                    String formedWord = new String(words);

                    if(formedWord.equals(endWord)){
                        return steps+1;
                    }

                    if(s.contains(formedWord)){
                        q.offer(new Pair(formedWord,steps+1));
                        s.remove(formedWord);
                    } 
                }
            }
        }
        return 0;
    }
}