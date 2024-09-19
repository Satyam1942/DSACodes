class Pair {
    int num;
    char operator;
    Pair(int num, char operator){
        this.num = num;
        this.operator = operator;
    }
}

class Solution {
    List<Integer> results = new ArrayList<>();
    public boolean isDigit(char token){
        return (int)token>=48 && (int)token<=57;
    }
    public void compute(int index, String expression, Stack<Pair> unevaluated) {

        int curNum = (int)expression.charAt(index)-48;
        if(index+1<expression.length() && isDigit(expression.charAt(index+1))) {
            curNum*=10;
            index++;
            curNum+=(int)expression.charAt(index)-48;
        }
 
        if(index+1==expression.length()) {
            Stack<Pair> temp = (Stack<Pair>)unevaluated.clone();
            while(!temp.isEmpty()) {
                char operator = temp.peek().operator;
                int prevNum = temp.peek().num;
                temp.pop();
                if(operator=='+')
                    curNum = prevNum+curNum;
                else if(operator == '-')
                    curNum = prevNum-curNum;
                else if(operator == '*')
                    curNum = prevNum*curNum;
            }
            results.add(curNum);
            return;
        }


        char nextOperator = expression.charAt(index+1);

        //not evaluating
        unevaluated.push(new Pair(curNum,nextOperator));
        compute(index+2,expression,unevaluated);
        unevaluated.pop();
        
        Stack<Pair> temp = (Stack<Pair>)unevaluated.clone();
        //evaluating
        while(!temp.isEmpty()){
            char operator =  temp.peek().operator;
            int prevNum = temp.peek().num;
            temp.pop();
            if(operator=='+')
                curNum = prevNum+curNum;
            else if(operator == '-')
                curNum = prevNum-curNum;
            else if(operator == '*')
                curNum = prevNum*curNum;
            
            temp.push(new Pair(curNum,nextOperator));
            compute(index+2,expression,temp);
            temp.pop();
        }
    }

    public List<Integer> diffWaysToCompute(String expression) {
        Stack<Pair> unevaluated = new Stack<>();
        compute(0,expression,unevaluated);
        return results;
    }
}

/*
    MEMOIZATION AND TABULATION SOLUTION ALSO EXISTS!!
*/