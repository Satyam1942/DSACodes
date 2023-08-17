#include <stdio.h>
#include "temp.c" // This is how we include another c program 
//STORAGE CLASSES IN C
/*
Auto == Local variable
static = static variable
external = global variable
register = storing variables in cpu instead of ram for 
faster access . Used for those variables which are frequently used
*/
int sum ;

int myfunc(int a ,int b )
{  
 extern int sum ; // if we use extern we szpecify function to store it in global variable
 //If we use auto then we specify function to stor in local variable
    return  sum;
}
int main(int argc, char const *argv[])
{
//Declaration - Telling compiler about variable (no space  reserved) 
//Definition -  Declaration + Initialization  (spoace reserveation)
// int sum = myfunc(3,5);
printf("The sum is %d\n",sum);

    return 0;
}
