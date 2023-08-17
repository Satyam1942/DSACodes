#include  <stdio.h>
// LOCAL , GLOBAL and STATIC VARIABLES
/*
Local varaibles are accessible only in its scope
Global variable are accessible everywhere
if local and global variable have same name then local variable will take preference
Formal arguments take preference over global variables

STATIC VARIABLES
static int num =90;
static line runs only once 
They preserve their value  of previous scope and are not initialized again
Staic variables are initialized to 0 if not initialized explicitly
In c , static variables can only be initialized using constant literals . 
It throws error if you initialize with variable or fucntion 
*/
int b = 34;//This is global variable
int ret()
{
    return 2;
}
int func1(int b)
{ static int var =0; //This is static variable
printf("The value of var is  %d\n", var);
//static int a  =ret(); this will throw error
    
    //   printf("The value of b inside func 1 is %d\n", b); // Here local varaiable will take preference 
    // printf("The address of b inside func1 is %d\n" , b);
    var++;
    return b + var;
}
int main(int argc, char const *argv[])
{
    int b =344; //This is local variable of main()
    int val = func1(b);
    val = func1(b);
    
    int* ptr  = &val;
    // printf("The address of b  inside main is %d\n",&b);
    // printf("The value of func1 is %d\n", val);
    return 0;
}
