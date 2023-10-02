class Solution {
    public boolean winnerOfGame(String colors) {
        int left =0 ,right = 0;
        int turnsAlice = 0, turnsBob = 0;
        while(right<colors.length())
        {
            if(colors.charAt(right)!=colors.charAt(left))
            {
                if(colors.charAt(left)=='A') turnsAlice+= Math.max(right-left-2,0);
                else turnsBob += Math.max(right-left-2,0);
                left =right;
            }
            right++;
        }

        if(colors.charAt(left)=='A') turnsAlice+= Math.max(right-left-2,0);
        else turnsBob += Math.max(right-left-2,0);

        return turnsAlice>turnsBob;
    }
}