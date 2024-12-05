class Solution {
    public boolean canChange(String start, String target) {
        int targetIndex = 0;
        int startIndex = 0;
        int length = start.length();

        while(startIndex<length || targetIndex<length) {
        
            while(startIndex<length && start.charAt(startIndex)=='_') {
                startIndex++;
            }
             
            while(targetIndex<length && target.charAt(targetIndex)=='_') {
                targetIndex++;
            }   

            if(startIndex==length && targetIndex==length) {
                return true;
            }
            
            if(startIndex==length || targetIndex==length) {
                return false;
            }
             
            if(start.charAt(startIndex)=='R') {
                if(targetIndex<startIndex) {
                    return false;
                } 
            }

            if(start.charAt(startIndex)=='L') {
                if(targetIndex>startIndex) {
                    return false;
                }
            }

            if(start.charAt(startIndex)!=target.charAt(targetIndex)) {
                return false;
            }

            startIndex++;
            targetIndex++;
        }

        return true;
    }
}

/*
    R
   R
 */