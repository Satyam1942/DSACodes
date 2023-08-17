// PRINT FIBONACCI SERIES
/*
1.Using recursion
2. Using for loop
Take value of n =42
*/
#include <stdio.h>
// Using recursion more time

// int fibn(int n)
// {
//     if (n==1)
//     return 0;
//     else if (n==2)
//     return 1;
//     else
//     return (fibn(n-1) + fibn(n-2));

// }
// int main(int argc, char const *argv[])
// {
//     int n;
//     printf("Enter a number\n");
//     scanf("%d", &n);
//     printf("The %d term of fibonacci series is %d\n",n,fibn(n));
//     return 0;
// }

// using loop  Takes less time
// int main(int argc, char const *argv[])
// {
//     int n;
//     printf("Enter a number\n");
//     scanf("%d", &n);
//     int a =0 , b=1,d,s;
//      if (n==1)
//     d=n-1;
//      else if (n==2)
//     d=n-1;
//     else{               
//     for (int i = 1; i <= (n-2); i++)
//     {
                   
                    
//                     d =a+b;
//                     a=b;
//                     b=d;
                    
//     }
//     }
//     printf("%d\n",d);
//     return 0;
// }
