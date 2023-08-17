#include <stdio.h>
//Recursive functions
//the case at which function doesn't recur is called base case
//case/instances at which function repeats is called recursive case
//every program that can be solved recursively can be solved iteratively
int fact(int n)
{
    if(n==1 || n==0 )
    {
return 1;
    }
    else
        return( n*fact(n-1));

}
int main(int argc, char const *argv[])
{
    int n;
    printf("Enter a number\n");
    scanf("%d\n",&n);
 
printf("Factorial is %d \n" , fact(n));
    return 0;
}
