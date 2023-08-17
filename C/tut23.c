#include <stdio.h>
//COMMAND LINE ARGUMENTS
/*
THE ARGUMENTS ARE PASSED IN MAIN METHOD
it is used to supply parameters to program when invoked
it is mostly used to control program from console
examples  :  FFmpeg, git , brew , apt-get , etc   
*/

// #include <stdio.h>
// int main(int argc, char const *argv[])//These are command line arguments
// {
//         printf("The value of argc is %d\n", argc);
//         for (int i = 0; i <argc; i++)
//         {
//             printf("This argument at index number %d has value %s\n" , i ,argv[i]);
//         }
            
//     return 0;
// }


//FUNCTION POINTERS
/*
this is used to point functions
used to implement callback functions
*/

//CALLBACK FUNCTIONS
/*
we cannot allocate or deallocate memory using function pointers
function pointers are used to pass function to another function
the passed function can be then called  again
*/
int sum(int a , int b)
{
    return a+ b;
}
void greetHelloAndExecute(int(*fptr)(int ,int))
{
    printf("hello World\n");
printf("Sum of a and b is  %d\n",fptr(5,7)) ;
}
void greetGoodMorningAndExecute(int(*fptr)(int ,int))
{
    printf("Good Morning User\n");
printf("Sum of a and b is  %d\n",fptr(5,7)) ;
}

int main(int argc, char const *argv[])
{       

        // printf("Sum is  %d/n" ,sum(1,2));
        int (*fptr) (int ,int); // creating a function pointer
        fptr = sum; // fptr  = sum and &sum both are same both will work beacuse function is itself address
// initializing a function  pointer
        // int d =  (*fptr)(4,6);  // dereferencing  a function pointer 
        // printf("The value of d is %d\n" , d); 
greetGoodMorningAndExecute (sum);
// greetHelloAndExecute(sum);
    return 0;
}
