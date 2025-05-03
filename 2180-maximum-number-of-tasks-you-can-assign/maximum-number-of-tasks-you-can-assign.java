class Solution {
    boolean isPossible(int k, int tasks[], int workers[], int pills, int strength) {
        int noOfTasks = tasks.length;
        int noOfWorkers = workers.length;
        TreeMap<Integer,Integer> workerMap = new TreeMap<>();
        int j = noOfWorkers-k;
        
        if(j<0) {
            return false;
        }

        for(int i=j;i<noOfWorkers;i++) {
            int freq = workerMap.getOrDefault(workers[i],0);
            workerMap.put(workers[i],freq+1);
        }

        for(int i=k-1; i>=0; i--) {
            Integer ceiling = workerMap.ceilingKey(tasks[i]);
            if(ceiling!=null) {
                int freq = workerMap.get(ceiling);
                if(freq==1) {
                    workerMap.remove(ceiling);
                } else {
                    workerMap.put(ceiling, freq-1);
                }
            } else {
                if(pills==0) {
                    return false;
                }
                int newTask = tasks[i]-strength;
                ceiling = workerMap.ceilingKey(newTask);
                pills--;
                if(ceiling==null) {
                    return false;
                } else {
                    int freq = workerMap.get(ceiling);
                    if(freq==1) {
                        workerMap.remove(ceiling);
                    } else {
                        workerMap.put(ceiling, freq-1);
                    }
                }
            }
        }
        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0;
        int right = tasks.length;
        int count = 0;

        while(left<=right) {
            int mid = (left+right)/2;
            if(isPossible(mid, tasks, workers, pills, strength)) {
                left = mid+1;
                count = mid;
            } else {
                right = mid-1;
            }
        }
        return count;
    }
}

/*
    workers = 1, 2, 4, 6, 6
    tasks = 5, 5, 8, 9

    4, 6, 6
    5, 5, 8

*/