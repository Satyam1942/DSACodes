#include <stdio.h>
int sum(int a , int b)//  a and b are formal parameters
{

}
void changeValue(int*a, int* b)
{
int s , d;
s =*a +*b;
d=*a - *b;
*a = s;
*b = d;
}
//Call by value  is just calling the function and passing the value of arguments in fgorm of const or variables
/*In Call by reference we pass the address of variables so that any change in that address made
 will also change the  value at local  variable of that function */
//SWAPING OF NUMBERS EXAMPLE OF CALL BY REFERENCE
void swap(int*x , int* y)
{
    int temp;
    temp = *x;
    *x=*y;
    *y=temp;
}
int main(int argc, char const *argv[])
{
    int x =2 , y =3;
    int s = sum(x,y);// x , y are actual parameters
    printf("The value of x and y is  %d and %d\n",x,y);
    changeValue(&x,&y);
    printf("THe value of x and y  now is %d and %d\n",x,y);
    
    printf("%d and %d\n",x,y);
    swap(&x,&y);
    printf("%d and %d\n",x,y);
    return 0;

}
