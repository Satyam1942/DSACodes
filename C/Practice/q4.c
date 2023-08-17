//QUESTION : FITTING THE ARRAY
/*
Geek is playing an array game. He is weak in the concepts of arrays. 
Geek is given two arrays arr[ ] and brr[ ] of the same size n. 
The array arr[ ] will be said to fit in array brr[ ] if by arranging the elements 
of both arrays, there exists a solution such that i'th element of arr[ ] is less than 
or equal to i'th element of brr[ ], for each i, 0 <= i < n. Help Geek find 
if the given array arr[ ] will fit in array brr[ ] or not.
Example 1:
Input: arr[] = {7, 5, 3, 2},
       brr[] = {5, 4, 8, 7} and n = 4
Output: YES
Explanation:
Transform arr[] = {2, 3, 5, 7} and
brr[] = {4, 5, 7, 8}.
Now, 2<=4, 3<=5, 5<=7 and 7<=8.
So arr[] array will fit in brr[] array.
Example 2:
Input: arr[] = {1, 2, 4},
       brr[] = {1, 2, 3} and n = 3 
Output: NO
Explanation: 
As 1<=1, 2<=2 but 4>3 so, 
arr[] array will not fit in brr[] array. 
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function isFit() that takes an array arr[], another array brr[], size of the array n and returns true if array arr[ ] fit in array brr[ ] otherwise returns false. The driver code takes care of the printing.
Expected Time Complexity: O(N*log(N)).
Expected Auxiliary Space: O(1).
Constraints:
1 ≤ N ≤ 105
0 ≤ a[i], b[i] ≤ 105
*/

//SOLUTION:

#include <stdio.h>

void sort(int arr[] , int n)
{
int a;
for (int i = 0; i < n; i++)
{
    for(int j =0 ; j<(n-1); j++)
    {
        if(arr[j]>arr[j+1])
        {
        a = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = a;
        }
        else
        continue;
    }
}
}

int isFit(int arr[] , int brr[] , int n)
{
int f= 0;
for (int i = 0; i < n; i++)
{
    if(arr[i]<=brr[i])
    f++;
}
if(f==n)
return 1;
else 
return 0; 
}

int main(int argc, char const *argv[])
{
    int n ;
    printf ("Enter the size of each array \n");
    scanf("%d",&n);

int arr[n], brr[n];

//array 1:
printf("Enter all elements of first array \n");
for (int i = 0; i < n; i++)
{
    scanf("%d", &arr[i]);
}
sort(arr,n);

//array 2:
printf("Enter all elements of second array \n");
for (int i = 0; i < n; i++)
{
    scanf("%d", &brr[i]);
}
sort(brr,n);


//carrying out function
if(isFit(arr, brr,n))
printf("YES");
else
printf("NO");


    return 0;
}
