class Solution {
    int getNoOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n/= 10;
        }
        return count;
    }

    // log(N)
    int generateSequentialNumber(int startingDigit, int length) {
        int number = 0;
        int digit = startingDigit;
        for (int i = 1; i <= length; i++) {
            number *= 10;
            number += digit;
            digit++;
        }
        return number;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> numbers = new ArrayList<>();

        // log N
        int lowDigitCount = getNoOfDigits(low);
        int highDigitCount = getNoOfDigits(high);
  
        for (int i = lowDigitCount; i <= highDigitCount; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                int seqNum = generateSequentialNumber(j, i);
                if(seqNum<=high && seqNum>=low)
                    numbers.add(seqNum);
            }
        }
        return numbers;

    }
}