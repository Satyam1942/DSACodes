class Pair
{
    int element , index;
    Pair(int element ,int index)
    {
        this.element = element;
        this.index= index;
    }
}

class Solution {
    void merge(int low , int high ,int mid , Pair arr[], int ans[])
    {
        int left = low;
        int right = mid+1;
        List<Pair> temp = new ArrayList<>();
        int noOfElementsRightArrayLessThanLeftArray = 0;
        while(left<=mid && right<=high)
        {
            if(arr[left].element<=arr[right].element)
            {
                ans[arr[left].index]+=noOfElementsRightArrayLessThanLeftArray;
                temp.add(new Pair(arr[left].element,arr[left].index));
                left++;
            }
            else 
            {
                noOfElementsRightArrayLessThanLeftArray++;
                temp.add(new Pair(arr[right].element,arr[right].index));
                right++;
            }
        }

        while(left<=mid)
        {
             ans[arr[left].index]+=noOfElementsRightArrayLessThanLeftArray;
                temp.add(new Pair(arr[left].element,arr[left].index));
                left++;
        }

        while(right<=high)
        {
            temp.add(new Pair(arr[right].element,arr[right].index));
            right++; 
        }


        for(int i=low;i<=high;i++)
        {
            arr[i] = temp.get(i-low);
        }
       
    }

    void mergeSort(int low, int high, Pair arr[], int ans[])
    {
        if(low>=high) return ;
        int mid = (low+high)/2;
        mergeSort(low,mid,arr,ans);
        mergeSort(mid+1,high,arr,ans);
        merge(low,high,mid,arr,ans);
    }
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        int ans[] = new int[length];
        Pair arr[] = new Pair[length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i] = new Pair(nums[i],i);
        }
        
        mergeSort(0,length-1,arr,ans);

        List<Integer> list = new ArrayList<>();
        for(int i:ans)list.add(i);

        return list;
        


    }
}