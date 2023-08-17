//STRING LIBRARY IN C
#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    char s1[] = "sonic";
    char s2[] = "tails";
    char s3[456];
    // puts(strcat(s1,s2)); this function concatinates s1 with s2 so now length of s1 will be 10
    printf("The length of s1 is %d\n" ,strlen(s1)); //to get length of string
    printf("The length of s2 is %d\n", strlen(s2));
    printf("The reverse of string 1 is : ");
    puts(strrev(s1));
    printf("\nThe reverse of string 2 is : ");
    puts(strrev(s2));//to get reverse of string
        // s3 =  strcat(s1,s2);  this will throw error
        strcpy(s3,strcat(s1,s2));
        puts(s3);
printf("%d\n",strcmp(s1,s2)); //return ASCII difference between the 1st different character of string

    return 0;
}
