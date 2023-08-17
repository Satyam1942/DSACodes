# include <stdio.h>
int main(int argc, char const *argv[])
{
    //LOOPS
    int num;
    printf("ENter a number\n");
    scanf("%d", &num);
    //DO WHILE LOOP
    //do while loop executes at least once even if initial condition is false
    int i=1;
    /*do
    {
        printf("%d\n",i);
        i++;

    } while (i<=num);
    */

   //WHILE LOOP
/*
   while (i<54)
   {
 printf("%d\n",i);
 i++;
   }
   */

  //FOR LOOP
  /* Properties of conditions
 We can h have more than one condition in for loop , the loop will iterate until last condition becomes false
 other conditions will be treated as statement 
the condition which is written in last will only be seen as condition
condition expression is optional
We can pass zero as well as non zero value in condition. non zero =true and zero = false
 */

/*PROPERTIES OF EXPRESSION 3
Used to update loop variable
multiple variable can be updated. 
It is optional*/

  int j;
for ( i = 0 , j =0; i < num , j<3; i++ , j++) //we can initialize more than one variable in loop
{
    printf("%d %d\n",i,j);
}

    return 0;
}