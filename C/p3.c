#include<stdio.h>
#include<string.h>
void sum(char b1 [20] , char b2 [20], int l1, int l2)
{
    char result[l1+2];
    int sum=0,carry=0;
    result[l1+1]='\0';
 for(int i=l2-1;i>=0;i--)
 {
        int n1 = b1[l1-1] -'0';
        int n2 = b2[i] -'0';
        sum = n1+n2+carry;
        if(sum>=2)
        {
            carry=1;
            sum%=2;
        }
    result[l1]=sum+'0';
        l1--;
        
    }

    while(l1>0)
    {
        int n = b1[l1-1] -'0';
        sum = n+carry;
        if(sum>=2)
        {
            carry=1;
            sum%=2;
        }
        result[l1]= sum+'0';
        l1--; 
    }

    if(carry)
    {
        result[0]='1';
    }
    else{
        result[0]='0';
    }
    printf("%s",result);
}
int main(int argc, char const *argv[])
{
    /* code */
    char  b1[20]; 
    char b2[20];
    scanf("%s",&b1);
    scanf("%s",&b2);
    int l1 = strlen(b1);
    int l2 = strlen(b2);
    if(l1>l2)
    {
        sum(b1,b2,l1,l2);
    }
    if(l1<l2)
    {
        sum(b2,b1,l2,l1);
    }
    return 0;
}
