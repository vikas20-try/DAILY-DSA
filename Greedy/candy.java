class Solution {
    public int candy(int[] ratings) {
        //here we calculate the right and left negibours to check and get correct out put
        int[] dist = new int[ratings.length];
        //since all get atleast 1
        Arrays.fill(dist,1);
        // camparing the left 
        for(int i = 1; i < ratings.length ; i++){
            if(ratings[i]>ratings[i-1]){
                dist[i] = dist[i-1] + 1;
            }
        }
        //comparing the right 
        for(int i = ratings.length-2 ;i>=0 ;i--){
            if(ratings[i]>ratings[i+1]){
                dist[i] = Math.max(dist[i], dist[i + 1] + 1);
            }
        }
        //counting 
        int count = 0;
        for(int x : dist){
            count += x;
        }
        return count;
    }
}