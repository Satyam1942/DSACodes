//UNIONS
/*
Very Similar to structure
User defined Data type
In structure  each memeber has its own memeory location
wwhereas in  Union  uses a single shraed memory location
We use Union for better memory management 
*/

#include <stdio.h>
#include <string.h>
union student
{
    int id;
    int marks;
    char fav;
    char name[34];
};

union tom
{
    int id;
    int marks;

};

int main(int argc, char const *argv[])
{
    union student s1;
    s1.id =1;
    s1.fav = 't';
   // s1.marks = 98;
   // strcpy(s1.name , "Sonic"); 
    // if we use union then only last thing remains and rest is curropt so we are getting string only correct here

    printf ("The id is %d\n " , s1.id);
    printf ("The  marks is %d\n " , s1.marks);
    printf ("The  fav character  is %c\n " , s1.fav);
    printf ("The string is %s\n " , s1.name);

    return 0;
}
