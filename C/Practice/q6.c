/*QUESTION:
Coin Change
MediumAccuracy: 47.19%Submissions: 100k+  Points: 4 Points
This problem is part of GFG SDE Sheet. Click here to view more.  

Given an integer array coins[ ] of size N representing different denominations of currency  and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
Note: Assume that you have an infinite supply of each type of coin. 


Example 1:

Input:
sum = 4 , 
N = 3
coins[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.
Example 2:

Input:
Sum = 10 , 
N = 4
coins[] ={2,5,3,6}
Output: 5
Explanation: Five Possible ways are:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
and {5,5}.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function count() which accepts an array coins[ ] its size N and sum 
as input parameters and returns the number of ways to make change for given sum of money. 


Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum)


Constraints:
1 <= sum, N <= 103

*/

//SOLUTION

#include <stdio.h>
#include <math.h>
 int count(int coins[] , int n , int sum);

void sort(int arr[] , int n)
 {
    int a;
    for (int i = 0; i < n; i++)
    {
        for(int j = 0 ; j<(n-1);j++)
        {
            if(arr[j]>arr[j+1])
            {
                a= arr[j];
                arr[j] = arr[j+1];
                arr[j+1]=a;
            }
            else
            continue;
        }
    }
    
 }

int main(int argc, char const *argv[])
{
    int n,sum;
printf("Enter number of available dominations\n");
scanf("%d",&n);

int coins[n];
printf("Enter value of dominations \n");
for (int i = 0; i < n; i++)
{
    scanf("%d",&coins[i]);
}

printf("Enter value of sum\n");
scanf("%d",&sum);

sort(coins, n);
count(coins , n , sum);


    return 0;
}


int  count(int coins[] , int n , int sum)
{
   int f=0 , a;
   a = sum/coins[0] ;
   int arr[a];
   for (int i = 0; i <n; i++)
   {
        //Sum with one element
        if (sum==arr[i])
        {
        f++;
        }

    
    
   }
   }

   //ON HOLD
   