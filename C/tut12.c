//INTRODUCTION TO  STRINGS
#include <stdio.h>
// void charStr(char str[])
// {
// int i=0;

// while(str[i]!='\0')
// {
// printf("%c",str[i]);
// i++;
// }
//}
int main(int argc, char const *argv[])
{char str[34];
    // char str[]={'h','a','r','r','y','\0'};
    // char str[]= "harry";
    // char str[5]= "harry"; this will give problems
    gets(str); //to take input of string
    printf("%s",str);
    //PRINTING STRING USING PUTS function
    puts(str);
    //we can take input of strings from scanf  but it does not capture vacant spaces
// charStr(str);
    return 0;
}
