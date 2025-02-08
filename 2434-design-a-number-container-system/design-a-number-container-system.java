class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> numberToIndex;
    HashMap<Integer, Integer> indexToNumber;

    public NumberContainers() {
        numberToIndex = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int mappedNumber = indexToNumber.get(index);
            numberToIndex.get(mappedNumber).remove(index);
            if(numberToIndex.get(mappedNumber).size()==0) {
                numberToIndex.remove(mappedNumber);
            }
        }

        indexToNumber.put(index, number);
        if (!numberToIndex.containsKey(number)) {
            numberToIndex.put(number, new TreeSet<>());
        }
        numberToIndex.get(number).add(index);
    }

    public int find(int number) {
        if (numberToIndex.containsKey(number)) {
            return numberToIndex.get(number).first();
        } else {
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */