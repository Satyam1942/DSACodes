class Pair {
    int number;
    int listNo;
    Pair(int number, int listNo) {
        this.number = number;
        this.listNo = listNo;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> combinedList = new ArrayList<>();
        int noOfList = nums.size();
        for(int i=0;i<noOfList;i++) {
            int sizeOfList = nums.get(i).size();
            for(int j=0;j<sizeOfList;j++) {
                combinedList.add(new Pair(nums.get(i).get(j),i));
            }
        }

        Collections.sort(combinedList,(a,b)->(a.number-b.number));

        int i=0,j=0;
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int lengthOfAllList = combinedList.size();
        int start = 0, end = Integer.MAX_VALUE;

        while(j<=lengthOfAllList) {
            if(freqMap.size()==noOfList) {
                int newStart = combinedList.get(i).number;
                int newEnd = combinedList.get(j-1).number;
                if((newEnd-newStart)<(end-start)) {
                    start = newStart;
                    end = newEnd;
                }

                int listNo = combinedList.get(i).listNo;
                int freq = freqMap.get(listNo);
                if(freq==1) {
                    freqMap.remove(listNo);
                } else {
                    freqMap.put(listNo,freq-1);
                }
                i++;
                continue;
            }

            if(j<lengthOfAllList) {
                int listNo = combinedList.get(j).listNo;
                int curFreq = freqMap.getOrDefault(listNo,0);
                freqMap.put(listNo,curFreq+1);
            }
            j++;
        }


        return new int[]{start,end};
    }
}

/*
    0=>[[4,10,15,24,26],
    1=>[0,9,12,20],
    2=>[5,18,22,30]]

    [(0,1), (4,0),(5,2),(9,1),(10,0),(12,1),(15,0),(18,2),(20,1),(22,2),(24,0),(26,0),(30,2)]
                                                            i                     j       
*/