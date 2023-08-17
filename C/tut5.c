#include <stdio.h>
int main()
{
    //  BREAK

    /*
    Used to bring program control out of loop or switch case
    */
int age;
   /*for (int i = 0; i < 10; i++)
   {
    printf("%d\n Enter your age\n" , i);
    scanf("%d",&age);
    
    if(age>10)
    break;
   }*/


   //CONTINUE
   /*
   CONTINUE skips code and goes to next iteration
   */
   
   /*for (int i = 0; i < 10; i++)
   {
    printf("%d\n Enter your age\n" , i);
    scanf("%d",&age);
    if(age>10)
    continue;
    printf("we have not come across continue");
   }*/

   //GO TO statement
   /*
   Also called jump statement
   Use to transfer progra to pre defined label
   It is used  when it is required to break multiple loops using single statement
   */  
/*
label:
printf("we are inside label");
goto end;
printf("Hello world");
goto label;
end:
printf("We are in end");  
  */  

    for (int i = 0; i < 8; i++)
    {
        printf("%d",i);
        for (int  j = 0; j <8; j++)
        {
            printf("Enter number , enter 0 to exit");
            scanf("%d",&age);
            if(age==0)
            goto label;
        }
        label:
        break;
        
    }
  return 0;  
}
