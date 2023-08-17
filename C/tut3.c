#include <stdio.h>
int main(int argc, char const *argv[])
{
    //IF ELSE IF
    int age;
    printf("Enter your age \n");
    scanf("%d",&age);
/*
    if(age>=18)
    {
        printf("You can vote\n");
    }
    else if(age>=10)
    printf("You are between 10 to 18 and you can  vote for kids \n");
    else
    printf("You cannot vote");
    return 0; */

    //SWITCH CASE STATEMENT
//if we dont use break it will automatically goto next case
//break exits switch cse
/* RULES OF SWITCH
1. Epression of switch must be int or char
2.value of case must be int or char
3. case must come inside switch
4. break is not a must
*/
int marks =45;

//NESTED SWITCH = SWITCH INSIDE SWITCH
    /*switch (age)
    {
    case 3 :
    printf("The age is 3\n");
        switch (marks)
        {
        case 45:
            printf("Your marks is 45");
            break;
        
        default:
        printf("your marks is not 45");
            break;
        }
    case 13 :
    printf("The age is 13\n");
        break;
    case 23 :
    printf("The age is 23\n");
        break;

    
    default:
    printf("Age is none");
        break;
    }
*/
}
