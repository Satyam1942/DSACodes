class FenwickTree{
    int size;
    int tree[];
    int totalElements;

    FenwickTree(int n){
        size = n;
        tree = new int[n+1];
        totalElements = 0;
    }

    public void add(int index, int delta){
        while(index<=size){
            tree[index]+=delta;
            index += (index&(-index));
        }
        totalElements++;
    } 

    public int greaterCount(int index){
        int floorCount = 0;
        while(index>0){
            floorCount+=tree[index];
            index -= (index&(-index));
        }
        return totalElements-floorCount;
    }

    public void update(int nums,HashMap<Integer,Integer> mapNumberToIndex){
        add(mapNumberToIndex.get(nums),1);
    }
}

class Solution {

    void compressNumbers(int[] nums, HashMap<Integer,Integer> mapNumberToIndex){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);

        int index = 1;
        for(int i:set){
            mapNumberToIndex.put(i,index);
            index++;
        }
    }

    public int[] resultArray(int[] nums) {
        HashMap<Integer,Integer> mapNumberToIndex = new HashMap<>();
        compressNumbers(nums,mapNumberToIndex);
        int numberOfUniqueNumbers = mapNumberToIndex.size(); 

        FenwickTree ft1 = new FenwickTree(numberOfUniqueNumbers);
        FenwickTree ft2 = new FenwickTree(numberOfUniqueNumbers);

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]); 
        ft1.update(nums[0],mapNumberToIndex);
    
        arr2.add(nums[1]);
        ft2.update(nums[1],mapNumberToIndex);

        for(int i=2;i<nums.length;i++){

            int indexOfNum = mapNumberToIndex.get(nums[i]);
            int greaterCount1 = ft1.greaterCount(indexOfNum);
            int greaterCount2 = ft2.greaterCount(indexOfNum);

            if(greaterCount1>greaterCount2){
                arr1.add(nums[i]);
                ft1.update(nums[i],mapNumberToIndex);
            }else if(greaterCount1<greaterCount2){
                arr2.add(nums[i]);
                ft2.update(nums[i],mapNumberToIndex);
            }else{
                if(arr1.size()<=arr2.size()){
                    arr1.add(nums[i]);
                    ft1.update(nums[i],mapNumberToIndex);
                }else{
                    arr2.add(nums[i]);
                    ft2.update(nums[i],mapNumberToIndex);
                }
            }
       
        }
      
        int res[] = new int[nums.length];
        int pointer = 0;
        for(int i:arr1)
            res[pointer++] = i;

        for(int i:arr2)
            res[pointer++] = i;

        return res;
    }
}