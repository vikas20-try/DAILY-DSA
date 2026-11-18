class Solution {
    public int minChanges(String s) {
        //here we want the minimum change need 
        //approach 1 checking in pair
        //since it is even length 
        int changes = 0;
        //checking 2 in row
        for(int i = 0 ; i < s.length() ;i+=2){
            if(s.charAt(i) != s.charAt(i+1)) changes++;
        }
        return changes;
    }
}