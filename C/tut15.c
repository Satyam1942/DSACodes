#include <stdio.h>
//TYPEDEF
typedef    struct tom  
 {
    int id;
    int marks;
    char fav;
    char name[34];
} std;
int main(int argc, char const *argv[])
{
    // typedef <previous_name> <alias_name>
    // typedef unsigned long ul;  // used to assign short name to long variables.  JUST LIKE NICKNAME
    // ul  l1 , l2,l3;
     
    //  typedef int i;
    //  i a =4;
    //  printf("Value of a is %d\n" , a);
    


    ///WHERE IS TYPEDEF USED

    std s1,s2; // if want to write struct tom as struct t then we use typedef
    s1.id = 34;
    s2.id =89;
    s1.marks =34;
    int *a,b;
    // here a will be treated as pointer and b will be treated as normal integer variable
    //so to solve pointer we write;

    typedef int* intPointer;
    intPointer a,b; //now both will be treated as pointer 

    return 0;
}
