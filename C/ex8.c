//DYNAMIC MEMORY ALLOCATION EXERCISE
/*
ABC pvt ltd manages employee record of other companies.
Employee id can be of any length  and can contain any character
for 3 employees you have to enter ,length of  employee id and employee id and display it on screen
store the employee id in character array which is allocated dynamically
You have to create only one character array dynamically 
*/
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char const *argv[])
{
int n;
char * ptr;

//FIRST EMPLOYEE
printf("EMPLOYEE 1:");
printf("Enter the length of your employee id ");
scanf("%d",&n);
ptr = (char*) (calloc ((n+1), sizeof(char)));


printf("Enter your employee id \n");
for (int i = 0; i < (n+1); i++)
{
    scanf("%c", &ptr[i]);
}

printf("Employee Id is ");
for (int i = 0; i < (n+1); i++)
{
printf("%c",ptr[i]);
}



//SECOND EMPLOYEE
printf("\nEMPLOYEE 2:");
printf("Enter the length of your employee id ");
scanf("%d",&n);
ptr = (char*) (realloc(ptr, (n+1)*sizeof(char)));


printf("Enter your employee id \n");
for (int i = 0; i < (n+1); i++)
{
    scanf("%c", &ptr[i]);
}

printf("Employee Id is ");
for (int i = 0; i < (n+1); i++)
{
printf("%c",ptr[i]);
}



//THIRD EMPLOYEE
printf("\nEMPLOYEE 3:");
printf("Enter the length of your employee id ");
scanf("%d",&n);
ptr = (char*) (realloc(ptr, (n+1)*sizeof(char)));


printf("Enter your employee id \n");
for (int i = 0; i <( n+1); i++)
{
    scanf("%c", &ptr[i]);
}

printf("Employee Id is ");
for (int i = 0; i < (n+1); i++)
{
printf("%c",ptr[i]);
}


free(ptr);

    return 0;
}

