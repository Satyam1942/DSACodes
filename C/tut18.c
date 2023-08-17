// DYNAMIC MEMORY ALLOCATION
/*
functions used malloc( ) , calloc(),realoc(), free()
in malloc() memory allocated is initialized by garabge value
in calloc() memory allocated is initialized by 0 .
*/
#include <stdio.h>
#include <stdlib.h> // calloc malloc and others are included in stdlib
int main(int argc, char const *argv[])
{
    //USE OF MALLOC
//     int *ptr;
//     int n;
//     printf("Enter the size of array you want to create");
//     scanf("%d",n);
//     ptr = (int *)malloc(n* sizeof(int)); returns a void pointer so we typecast into int pointer
// for (int i = 0; i < 3; i++)
// {
//     printf("Enter the value no %d of array\n",i);
// scanf("%d",&ptr[i]);
// }
// for (int i = 0; i < 3; i++)
// {
//     printf("the value at %d of array is %d\n",i,ptr[i]);

// }
//USE OF CALLOC
 int *ptr;
    
    ptr = (int *)calloc(3, sizeof(int));
for (int i = 0; i < 3; i++)
{
    printf("Enter the value no %d of array\n",i);
scanf("%d",&ptr[i]);
}
for (int i = 0; i < 3; i++)
{
    printf("the value at %d of array is %d\n",i,ptr[i]);

}
//USE OF REALLOC
 
    int n;
    printf("Enter the new  size of array you want to create\n");
    scanf("%d",&n);
    ptr = (int *)realloc(ptr,n* sizeof(int));
for (int i = 0; i < n; i++)
{
    printf("Enter the value no %d of array\n",i);
scanf("%d",&ptr[i]);
}
for (int i = 0; i < n; i++)
{
    printf("the value at %d of array is %d\n",i,ptr[i]);

}
//USE OF FREE
free(ptr);
    return 0;
}
