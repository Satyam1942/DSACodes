// QUESTION: Minimum Cost of ropes
/*
There are given N ropes of different lengths, we need to connect these ropes into one rope.
The cost to connect two ropes is equal to sum of their lengths. The task is to
connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes.

Example 1:
Input:
n = 4
arr[] = {4, 3, 2, 6}
Output: 
29
Explanation:
We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Which makes the array {4, 5, 6}. Cost of
this operation 2+3 = 5. 
2) Now connect ropes of lengths 4 and 5.
Which makes the array {9, 6}. Cost of
this operation 4+5 = 9.
3) Finally connect the two ropes and all
ropes have connected. Cost of this 
operation 9+6 =15
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. 
Other ways of connecting ropes would always 
have same or more cost. For example, if we 
connect 4 and 6 first (we get three rope of 3,
2 and 10), then connect 10 and 3 (we get
two rope of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.

*/

// SOLUTION 1: Using array sorting and element replacement 
//Solution 2 : USING DYNAMIC MEMORY ALLOCATION
#include <stdio.h>

//To sort the array
 void sort(int arr[],int n)
 {
 int a;
    for (int j = 0; j < n; j++)
    {
        for (int i = 0; i < n - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                a = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = a;
            }
            else
                continue;
        }
    }
 }

int main(int argc, char const *argv[])
{
    int n, cost = 0;
    printf("Enter the number of ropes\n");
    scanf("%d", &n);
    int arr[n];

    printf("Enter the lengths of all ropes\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    

    sort(arr,n);

   //adds the lengths in ascending order and replaces elements of array
    int a;
    for (int i = 0; i < n; i++)
    {
        a = arr[0] + arr[1];
        arr[0] = a;
        for (int j = 1; j < n; j++)
        {
            arr[j] = arr[j+1];
        }
        
    sort(arr, n-1-i);
        
         if(i<n-1)
        cost = cost + a;
        else
        break;
        }

    printf("The minimum cost is  %d\n", cost);
    return 0;
}
