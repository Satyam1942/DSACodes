class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int numberOfCards = deck.length;
        int orderedCardArray[] = new int[numberOfCards];
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);

        for (int i = 0; i < numberOfCards; i++)
            q.add(i);
        int pointer = 0;
        while (!q.isEmpty()) {
            int firstCardIndex = q.poll();
            int secondCardIndex = (!q.isEmpty()) ? q.poll() : -1;
            orderedCardArray[firstCardIndex] = deck[pointer++];
            if (secondCardIndex != -1)
                q.add(secondCardIndex);
        }
        return orderedCardArray;

    }
}

/*
 * 2,3,5,7,11,13
 * 2 7 3 13 5 11
 * 0 2 4 6
 * 
 */