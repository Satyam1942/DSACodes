//QUESTION :  Find the median
/*
Given an array arr[] of N integers, calculate the median
 Example 1:
Input: N = 5
arr[] = 90 100 78 89 67
Output: 89
Explanation: After sorting the array 
middle element is the median 

Example 2:
Input: N = 4
arr[] = 56 67 30 79
Output: 61
Explanation: In case of even number of 
elements, average of two middle elements 
is the median.
*/


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

#include <stdio.h>
int main(int argc, char const *argv[])
{

int n ;
printf("Enter the length of array \n");
scanf("%d",&n);

int arr[n];

printf("Enter elements of array \n");
for (int i = 0; i < n; i++)
{
    scanf("%d", &arr[i]);
}

sort(arr, n);


if(n%2==0)
printf("Median is %d \n", ((arr[(n/2) -1]) +  (arr[n/2]))/2) ;
else
printf("Median is %d\n" , arr[((n+1)/2) - 1]);



    return 0;
}
