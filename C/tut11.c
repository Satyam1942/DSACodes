#include <stdio.h>
//by passsing array as parameter
void func1(int arr[])
{
    for (int i = 0; i < 4; i++)
    {
        printf("value at %d  is %d\n" , i ,arr[i]);
    }
    arr[0] =326; // if we  change the value here it gets reflected in main
    
}
// by passing base address of array and using its address
void func2(int* ptr)
{
for (int i = 0; i < 4; i++)
    {
        printf("value at %d  is %d\n" , i ,*(ptr+i)); // you can alwso write ptr[i]
    }
}
int main(int argc, char const *argv[])
{
int arr[] = {23,13,3,4};
printf("%d",arr[0]);
func1(arr);
printf("%d",arr[0]);

    return 0;
}
