class Solution {
    void rec(int [] arr, int index ,int target, List<Integer> list,  List<List<Integer>> ans, boolean prevPicked) {

        if(index==arr.length) {
            if(target==0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(index>0 && arr[index]==arr[index-1] && !prevPicked || arr[index]>target) 
            rec(arr,index+1,target,list,ans,false);
        else if(arr[index]<=target) {  
            rec(arr,index+1,target,list,ans,false);

            prevPicked = true;
            list.add(arr[index]);
            rec(arr,index+1,target-arr[index],list,ans, prevPicked);
            list.remove(list.size()-1);
            prevPicked = false;
        }    
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int picked[] = new int[candidates.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        rec(candidates,0,target, list, ans, false); 

        return ans;
    }
}