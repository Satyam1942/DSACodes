#include <stdio.h> /*this is used to include input function*/
int main(int argc, char const *argv[])
{
 /*   printf("Hello World \n");
    int a ,b;
    printf("Enter a number a \n");
    scanf("%d",&a); /* &a means address of a*/
 /*   printf("Enter a number b \n");
   scanf("%d",&b);
   printf ("Sum is %d\n" , (a+b)); */
 
 printf("%lu\n" , sizeof(int)); //lu = unsigned long
 printf("%lu\n" , sizeof(char)); 
 printf("%lu\n" , sizeof(long)); 
 printf("%lu\n" , sizeof(float)); 

 //operators 
/*
 int c ,d;
 c =34;
 d=6;
 printf("a + b= %d\n" , c+d);
 printf("a - b= %d\n" ,c-d);
 printf("a X b= %d\n" ,c*d);
 printf("a / b= %d\n" ,c/d);
 
 int e ; float f; 
 e =34;
 f=6.34;
  printf("a + b= %f\n" , e+f); //for float we use f
 printf("a - b= %f\n" ,e-f);
 printf("a X b= %f\n" ,e*f);
 printf("a / b= %f\n" ,e/f);*/
  
  //boolean
  /*in C boolean is processed by converting numbers into binary.
  The binary for 2 is 10 and 3 is 11 . Then it performs bitwise operation to give 10 which is 2*/
  printf("%d\n", 2&3);
  //XOR opeartor id  a^b

  //assignment operator
/* = , += , -= *= , /=  first adds,subtracts , multiplies , divides and then assign its value */

// & is address of operator
// * --> pointer to variable

    return 0;
}
