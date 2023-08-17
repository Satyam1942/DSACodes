//QUESTION 3: Replace all 0's with 5

/*
Given a number N. The task is to complete the function convertFive() which replace 
all zeros in the number with 5 and returns the number.
Input:
The first line of input contains an integer T, denoting the number of testcases. 
Then T testcases follow. Each testcase contains a single integer N denoting the number.
Output:
The function will return integer where all zero's are converted to 5.
User Task:
Since this is a functional problem you don't have to worry about input, 
you just have to complete the function convertFive().
Constraints:
1 <= T <= 103
1 <= N <= 104
Example:
Input
2
1004
121
Output
1554
121
Explanation:
Testcase 1:  At index 1 and 2 there is 0 so we replace it with 5.
Testcase 2: There is no ,0 so output will remain same.
*/

//SOLUTION:
#include <stdio.h>

void convertFive(int arr[] , int m)
{
for (int i = 0; i < m; i++)
{
int a,n=0,revNum=0;
    
    //CONVERTS 0 TO 5 AND STORES NUMBER IN INVERTED FORM
    while (arr[i]!=0)
    {
      a= arr[i]%10;
       n *=10;  

      if(a==0)
       {
       n+=5;
       }
       else
      {   
        n+=a;
      }
        arr[i]/=10; 
    }

    //reversing n
    while (n!=0)
    {
      a= n%10;
    revNum *=10;  
      if(a==0)
       {
       revNum+=5;
       }
       else
       revNum+=a;
       n/=10; 
    }
    
    arr[i] = revNum;
}


//PRINTING ARRAY
printf("The New Array is\n");
for (int i = 0; i < m; i++)
{
    printf("%d\n", arr[i] );
}

}

int main(int argc, char const *argv[])
{
    int N ;
    printf("Enter value of N\n");
    scanf("%d", &N);

int T[N];
printf("Enter all testcases\n");
for (int i = 0; i < N; i++)
{
    scanf("%d", &T[i]);
}
    
convertFive(T , N);


    return 0;
}
