#include <stdio.h>
//Pointers are  variables which store address of other variable
//Can be of type int , array , char, function
//declared using * symbol
/*
&---> means address of operator (to get address of variable)
*---> dereference operator (to get value at address)
*/ 
// int main(int argc, char const *argv[])
// {
//     int a=76;
//     int* ptr = &a;
//     int* ptr2 = NULL; //NULL POINTER
//     printf("The value of a is %d\n",*ptr);
//     printf("The value of address of a is %x\n",ptr); // %x --> is format specifier for hexadecimal
//     //%p is format specifier for pointers
//     printf("The value of address of pointer to a is %p\n",&ptr); // %x --> is format specifier for hexadecimal
//     return 0;
// }
//NULL POINTER 
/*
a pointer assigned no value is NULL
it does not point to anything;
we can use it to initialize a pointer when pointer variable isn't assigned  any valid memory address
int *ptr = NULL;
*/
//USE OF POINTER
/*
Used in Arrays , Functions and Structures
Dynamic memory allocation
*/



// ARRAY AND POINTER ARITHMETIC
/*
There are 4 arithmetic operators can be used on pointers 
++ , -- , + , -

*/

// int main(int argc, char const *argv[])
// {
//     int a =34;
//     int*ptra = &a;
//     printf("%d\n",ptra);
//     printf("%d\n",ptra+1); // +1 add one size of int
//     char b;
//     printf("%d\n",&b);
//     printf("%d\n",&b+1);//char takes one byte so it adds , subtracts one byte 
//     ptra++;
//     printf("%d\n",ptra);
//     return 0;
// }

//ARRAYS AND POINTERS
/*
REMEMBER 
&arr[0] will give same value as  int* ptr = arr;
arr[i] == *(arr+i);
*/

int main(int argc, char const *argv[])
{
    int arr[]= {1,2,3,54,5,6,7,56};
    printf("array at position 3 of array is %d\n", arr[3]);
    printf("%d\n",&arr[0]);
    printf("%d\n",arr);
    printf("%d\n",&arr[1]);
    printf("%d\n",arr+1);
    printf("%d\n", *(&arr[0]));
    printf("%d\n", *(&arr[1]));
    printf("%d\n", *arr);
    printf("%d\n", *(arr+1));


    // arr++; // arr is constant YOU CANNOT DO arr++ it shows error
    int* p = &arr; //but we can assign it to another pointer variable and then change it
    p++;

    return 0;
}


