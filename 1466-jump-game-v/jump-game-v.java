class Solution {
    int dfs(int index, int arr[] , int distance,Integer cache[]){
        
        if(cache[index]!=null)
            return cache[index];

        int maxIndex = Math.min(index+distance,arr.length-1);
        int minIndex = Math.max(index-distance,0);
        int res = 1;
        for(int i=index;i<maxIndex;i++){
            if(arr[i+1]>=arr[index]){
                break;
            }else{
                int temp = 1+ dfs(i+1,arr,distance,cache);
                res = Math.max(res,temp);
            }
        }

        for(int i=index;i>minIndex;i--){
            if(arr[i-1]>=arr[index]){
                break;
            }else{
                int temp = 1+dfs(i-1,arr,distance,cache);
                res = Math.max(res,temp);
            }
        }

        return cache[index] = res;
    }
    public int maxJumps(int[] arr, int distance) {
        Integer cache[] = new Integer[arr.length];

        int maxi = 0;
        for(int startIndex = 0;startIndex<arr.length;startIndex++){
            int res =  dfs(startIndex,arr,distance,cache);
            maxi = Math.max(maxi,res);
        }

        return maxi;

    }
}