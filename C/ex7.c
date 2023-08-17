//QUESTION
/*
You manage a travel agency . You waznt your n  drivers to input their following details:
1. Name
2. Driving license NO
3.Route
4. No ok kms driven
your program should be able to take n as input and your drivers will start inputting their details one by one
Your program should print details of drivers in beautiful fashion
use n =3 for simplicity
Use structures
*/
//SOLUTION
#include <stdio.h>
#include <string.h>

struct driverData
{
    char name[34];
    int licenseId;
    char route[34];
    int kms;
};

void clearBuffer()
{
    int ch;
    while ((ch=getchar()) !='\n' && ch!=EOF);
    
}
int main(int argc, char const *argv[])
{//NOTE WHENERVER WE USE gets() after scanf() it does not work because scanf adds new line 
//so use clear buffer function after scanf  or use  fflush(stdin)
    int n; 
    printf("Enter the number of drivers \n");
    scanf("%d",&n);
    fflush(stdin);
    struct driverData arr[n];
    for (int i = 0; i < n; i++)
    {   
      
         printf("Enter your name\n");
        gets(arr[i].name);
        
        printf("Enter your license id\n");
        scanf("%d",&arr[i].licenseId);
        fflush(stdin);
        
        printf("Enter the route in which you drive\n");
        gets(arr[i].route);
        
        printf("Enter the distance in kms you have driven\n");
        scanf("%d",&arr[i].kms);
    fflush(stdin);
        
    }
        printf("S No\t");
        printf("Name\t");
        printf("Licence ID\t");
        printf("Route\t");
        printf("\t\tDistance\n");
   
    for (int i = 0; i < n; i++)
    {
        printf("%d\t",(i+1));
        printf("%s\t",arr[i].name);
        printf("%d\t",arr[i].licenseId);
        printf("\t%s\t",arr[i].route);
        printf("\t%d\n",arr[i].kms);
        
    }
      

    return 0;
}
