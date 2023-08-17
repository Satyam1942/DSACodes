//To check if number is pallindrome or not 
#include <stdio.h>
int checkPalindrome(int num)
{
int revNum=0;
int original_num = num;
//Checking if pallindrome
while ((num%10)!= 0)
{
    revNum*=10;
    revNum += num%10;
    num/=10;
}

//printf("%d %d",original_num , revNum);

if(revNum == original_num)
return 1;
else
return 0;
}


int main(int argc, char const *argv[])
{
    int n;
    printf("Enter a number \n");
    scanf("%d", &n);
    if (checkPalindrome(n))
        printf("This number is a palindrome number \n");
    else
        printf("This number is not a palindrome \n");
}