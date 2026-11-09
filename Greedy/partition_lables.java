class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length();i++){
            int startIndex = i;
            int endIndex = s.lastIndexOf(s.charAt(i));
            for(int str = startIndex+1 ; str <= endIndex  ; str++){
                    int lastIndexofChar = s.lastIndexOf(s.charAt(str));
                    if(lastIndexofChar > endIndex){
                        endIndex = lastIndexofChar;
            }
          }
            list.add(endIndex - startIndex + 1);
            i = endIndex ;
    }
    return list;
    }
}