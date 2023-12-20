class Solution {
    boolean isValidIP(String ip)
    {
        String number = "";
        int noOfDots= 0;
        for(int i=0;i<=ip.length();i++)
        {
            if(i==ip.length() || ip.charAt(i)=='.' )
            {
                noOfDots++;
                if(i==ip.length() && noOfDots<4) return false;
                // to check 1.1.11.1.1
                if(noOfDots>4) return false;

                //to check .1235.
                if(Long.valueOf(number)>255l) return false;

                //to check .000.
                if(number.length()>1 && number.charAt(0)=='0') return false;

                number =  "";
            }
            else number+=ip.charAt(i);
        }
        return true;
    }

    void rec(String s, int index, String ip, List<String> validIP)
    {
        if(index==s.length())
        {
            if(isValidIP(ip)) validIP.add(ip);
            return;
        }

        rec(s,index+1,ip+String.valueOf(s.charAt(index)), validIP);

        if(ip.length()>0 && ip.charAt(ip.length()-1)!='.')  rec(s,index,ip+'.',validIP);
    }

    public List<String> restoreIpAddresses(String s) {

        int length = s.length();
        List<String> validIP = new ArrayList<>();

        if(length>12) return validIP;

        rec(s,0,"",validIP);

        return validIP;
    }
}