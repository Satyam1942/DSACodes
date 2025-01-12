class Solution {
    boolean validateLeftToRight(String s, String locked) {
        int length = s.length();
        int unlocked = 0;
        int balance = 0;
        for(int i=0;i<length;i++) {
            char token = s.charAt(i);
            if(locked.charAt(i)=='0') {
                unlocked++;
            } else {
                if(token!=')') {
                    balance++;
                } else {
                    balance--;
                }
            }
            if(balance+unlocked<0) {
                return false;
            }
        }
        return balance<=unlocked;
    }

    boolean validateRightToLeft(String s, String locked) {
        int length = s.length();
        int unlocked = 0;
        int balance = 0;
        for(int i=length-1;i>=0;i--) {
            char token = s.charAt(i);
            if(locked.charAt(i)=='0') {
                unlocked++;
            } else {
                if(token!='(') {
                    balance++;
                } else {
                    balance--;
                }
            }
            if(balance+unlocked<0) {
                return false;
            }
        }
        return balance<=unlocked;
    }

    public boolean canBeValid(String s, String locked) {
        int length = s.length();
        return length%2==0 && validateLeftToRight(s,locked) && validateRightToLeft(s,locked);
    }
}
