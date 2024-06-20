class Solution {
    StringBuilder minLengthPassword = new StringBuilder();

    boolean generatePasswords(StringBuilder sourcePassword , HashSet<String> visPasswords, int n, int k){

        int length = sourcePassword.length();
        String lastNCharacters = sourcePassword.substring(length-n,length);

        if(visPasswords.contains(lastNCharacters))
            return false;

        visPasswords.add(lastNCharacters);
        
        if(visPasswords.size()==Math.pow(k,n))
            return true;

        for(int i=0;i<k;i++){
            char token = (char)(i+48);
            sourcePassword.append(token);
            boolean res =  generatePasswords(sourcePassword,visPasswords,n,k);
            if(res){
                minLengthPassword.append(token);
                return true;
            }
            sourcePassword.deleteCharAt(length);
        }

        visPasswords.remove(lastNCharacters);
        return false;
    }

    public String crackSafe(int n, int k) {
        StringBuilder sourcePassword = new StringBuilder();
        HashSet<String> visPasswords = new HashSet<>();

        for(int i=0;i<n;i++)
            sourcePassword.append('0');

        generatePasswords(sourcePassword, visPasswords,n,k);
        
        for(int i=0;i<n;i++)
            minLengthPassword.append('0');

        minLengthPassword.reverse();
        return minLengthPassword.toString();
    }
}

/*
00
*/