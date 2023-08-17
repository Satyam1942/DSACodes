#include <stdio.h>
//VOID POINTER
/*
General purpose pointer
deferenced by typecasting
can't use pointer arithmetic
used in malloc() calloc() dyanmic memeory allocation
// */
// int main(int argc, char const *argv[])
// {
//     int a = 345;
//     float b =8.3;
//     void *ptr; // we cannot directly dereference void pointer
//     ptr=&a;
//     printf("the value of a is %d\n",*((int *)ptr) );//typecasting void pointer to integer pointer now it will print a
//    ptr =&b;
//     printf("the value of a is %f\n",*((float *)ptr) );//typecasting void pointer to float pointer now it will print a
//     return 0;
// }

//NULL POINTER
/*
cannot be derefernced until defined . Use to initialize pointer to point into nothing
*/
int main(int argc, char const *argv[])
{
    //printing dereferenced null pointer crashes a program . you cannot deference a null pointer
int a =34;
int * ptr ; // This is unitialized pointer this can be dereferenced and will give garbage value
ptr= NULL; // NOW IT IS NULL POINTER
ptr =&a;
if (ptr!=NULL)
printf("The address of a  is  %d\n", *ptr); 
else
printf("The pointer is null pointer and cannot be  dereferenced \n");
    return 0;
}
//Dangling pointer 



