class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence2.length()>sentence1.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        String words1[] = sentence1.split(" ");
        String words2[] = sentence2.split(" ");
        int length1 = words1.length;
        int length2 = words2.length;

        int index1 = 0, index2 = length2-1, index3 = length1-1;
        while(index1<length2 && words1[index1].equals(words2[index1])) {
            index1++;
        }

        while(index2>=0 && words1[index3].equals(words2[index2])) {
            index2--;
            index3--;
        }
   
        return index2<index1;

    }
}