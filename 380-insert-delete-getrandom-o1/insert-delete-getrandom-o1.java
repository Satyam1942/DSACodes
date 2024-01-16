class RandomizedSet {
    List<Integer> randomSet ;   
    HashMap<Integer,Integer> set; 

    public RandomizedSet() {
        randomSet = new ArrayList<>();
        set = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(set.containsKey(val))
            return false;
        else 
            {
                set.put(val,randomSet.size());
                randomSet.add(val);
                return true;
            }
    }
    
    public boolean remove(int val) {
        if(!set.containsKey(val))
            return false;
        else{

            int lastIndex = randomSet.size()-1;
            int index = set.get(val);
            int temp = randomSet.get(lastIndex);

            randomSet.set(index,temp);
            randomSet.set(lastIndex,val);
            set.put(temp,index);

            randomSet.remove(lastIndex);
            set.remove(val);

            return true;
        }
    }
    
    public int getRandom() {
        int length = randomSet.size();
        int randomIndex = (int)(Math.random()*(length));
        return randomSet.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */