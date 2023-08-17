#include<stdio.h>
void swap(int arr[],int low ,int pointer)
{
int temp = arr[pointer];
arr[pointer] = arr[low];
arr[low] =temp;
}
int main(int argc, char const *argv[])
{   
    //Taking input
    int arr[20];
    int size =0;
    printf("Enter size of array\n");
    scanf("%d",&size);
    printf("Enter elements of array\n");
    for(int i=0;i<size;i++)
    {
       scanf("%d",&arr[i]);
    }

    //To swap 0's with 1's
    int low =0,pointer =0;
    while(pointer<size)
    {
        if(arr[pointer]==0){ swap(arr,low,pointer); low++;}
        pointer++;

    }

    //Printing new array
    for(int i=0;i<size;i++)
    {
        printf("%d\n",arr[i]);
    }


    return 0;
}
