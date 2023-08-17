// Question :
/*
Given an aray of N integers. Find the first element to occur N times
make the function  functionElementKtime(int arr[] , int n ) and return integer k.
If answer is not present return -1;
Example 1:
N =7 , k=2;
A[] = {1,7,4,3,4,8,7}
Output : 4
*/

// Solution

#include <stdio.h>

int functionElementKTime(int arr[], int n, int k);

int main(int argc, char const *argv[])
{
    int n;
    printf("Enter the number of elements in array \n");
    scanf("%d", &n);

    int arr[n];

    printf("Enter Elemnts of array\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    int k;
    printf("Enter the value of K\n");
    scanf("%d", &k);

    printf("%d is the first element that occurs %d times \n",functionElementKTime(arr, n, k), k);

    return 0;
}

int functionElementKTime(int arr[], int n, int k)
{
    int f=1, a,b;
    a=n;
    
   for (int i = 0; i < n; i++)
    {
       for (int j = i+1; j < n; j++)
       {
        if (arr[i] == arr[j])
        { 
            f++;
            if(a>j)
            {
                a=j;
            }
            
        }

       }
       if (f==k)
       {
        b= arr[a];
    
       }
       f=1;

    }

    return b;
}
