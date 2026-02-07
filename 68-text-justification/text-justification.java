class Solution 
{
    public List<String> fullJustify(String[] words, int maxWidth) 
    {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;)
        {
            String word =words[i];
            if(sb.length()==0)
            {
                sb.append(word);i++;
            }
            else if(sb.length()+word.length()+1<=maxWidth)
            {
                sb.append(" "+word);i++;
            }
            else
            {
                int wordsLength  = sb.toString().split(" ").length;
                int requiredSpaces  =maxWidth -( sb.length() -(wordsLength-1));
                int spaceBwWords =  requiredSpaces / ((wordsLength-1)>0?(wordsLength-1):1); 
                int extraSpaces = requiredSpaces % ((wordsLength-1)>0?(wordsLength-1):1);
                String spaces = "";
                for(int j = 0;j<spaceBwWords;j++)  spaces+=" ";
                String list[] = sb.toString().split(" ");
                String ans = "";
                for(int j = 0;j<wordsLength;j++)
                {
                    if(wordsLength==1)
                        ans+=list[j]+=spaces;
                    else if(j==wordsLength-1)
                        ans+=list[j];
                    else if(extraSpaces>0){
                        ans+=list[j]+spaces+" ";
                        extraSpaces--;
                    }
                    else 
                        ans+=list[j]+spaces;
                }
                res.add(ans);
                sb = new StringBuilder();
            }
        }
        int sbLength = sb.length();
        for(int j = 0;j<(maxWidth - sbLength);j++)  sb.append(" ");
        res.add(sb.toString());
        return res;
    }
}