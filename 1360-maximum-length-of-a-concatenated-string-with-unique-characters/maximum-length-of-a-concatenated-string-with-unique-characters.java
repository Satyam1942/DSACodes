class Solution {

    boolean checkUnique(HashSet<Character> uniqueSet, String temp) {
        HashSet<Character> tempSet = new HashSet<>();
        for (int i = 0; i < temp.length(); i++) {
            char token = temp.charAt(i);
            if (uniqueSet.contains(token) || tempSet.contains(token))
                return false;
            tempSet.add(token);
        }
        return true;
    }

    void addToSet(HashSet<Character> uniqueSet, String temp) {
        for (int i = 0; i < temp.length(); i++) {
            char token = temp.charAt(i);
            uniqueSet.add(token);
        }

    }

    void removeFromSet(HashSet<Character> uniqueSet, String temp) {
        for (int i = 0; i < temp.length(); i++) {
            char token = temp.charAt(i);
            uniqueSet.remove(token);
        }

    }

    int maximum = 0;

    void maxLength(String arr[], int index, HashSet<Character> uniqueSet) {

        if (index == arr.length) {
            int curLength = uniqueSet.size();
            maximum = Math.max(maximum, curLength);
            return;
        }

        String temp = arr[index];

        // notTake
        maxLength(arr, index + 1, uniqueSet);

        // take
        if (checkUnique(uniqueSet, temp)) {
            addToSet(uniqueSet, temp);
            maxLength(arr, index + 1, uniqueSet);
            removeFromSet(uniqueSet, temp);
        }

    }

    public int maxLength(List<String> arr) {
        String arrStr[] = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrStr[i] = arr.get(i);
        }
        HashSet<Character> set = new HashSet<>();
        maxLength(arrStr, 0, set);
        return maximum;
    }
}