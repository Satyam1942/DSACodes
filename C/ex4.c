//triangular star pattern
/*
*
**
***
****
*****
*/
//reversed triangular star pattern

/*
******
****
***
**
*

*/

//Take input from user to get star pattern --0 , to get reversed star pattern--1

#include <stdio.h>
int main(int argc, char const *argv[])
{
    int n,val;
    printf("STAR PROGRAM\n");
    label:
    printf("Enter 0 to print star pattern and 1 to print reverse star pattern\n");
    scanf("%d",&n);
    if(n==0)
    {
        printf("Enter the number of rows in pattern \n");
        scanf("%d",&val);
        printf("STAR PATTERN IS\n");
        for (int i = 1; i <= val; i++)
        {
                for (int j = 1; j <=i ; j++)
                {
                    printf("*");
                }
                printf("\n");
        }
        
    }
    else if(n==1)
    {
        printf("Enter the number of rows in pattern \n");
        scanf("%d",&val);
        printf(" REVERSE STAR PATTERN IS\n");
        for (int i = val; i >= 1; i--)
        {
                for (int j = 1; j <=i; j++)
                {
                    printf("*");
                }
                printf("\n");
        }
              
    }
    else
    {
        printf("WRONG INPUT TRY AGAIN.\n ");
            goto label;
    }
    return 0;
}
