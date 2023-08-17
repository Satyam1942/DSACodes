#include <stdio.h>
int sum(int , int ); // This is function prototype . If you are writing function later you have to tell compiler first 
void printStar(int s);
int main(int argc, char const *argv[])
{
    //FUNCTIONS
    //Also called procedure or sub routine
    int a, b,s;
    a =9;
    b=87;
    int c = sum(a,b);
    printf("The sum is %d\n",c);
   printf("Enter  number of times you need to print star\n");
    scanf("%d",&s);
     printStar(5);
    return 0;
}
int sum (int a , int b)
{
    return a+b;
}
void printStar(int s)
{
for(int i=1; i<=s;i++)
{printf("%c",'*');
}
}
