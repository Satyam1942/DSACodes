#include <stdio.h>
#include <string.h>
// STRUCTURES
/*
(.) operator is used to access structure members
it is also called  structure member operator
 */

struct tom
{
    int id;
    int marks;
    char fav;
    char name[34];
} s4, s5, s6;          // This is also one way to  assign variables of struct. These will act as global variables
struct tom s1, s2, s3; // These are global variables
int main(int argc, char const *argv[])
{
    struct tom sonic, tails, knuckles; // this will act as local variables
    sonic.marks = 90;
    sonic.fav = 'o';
    sonic.id = 1;
    strcpy(sonic.name, "sonic"); // using strcpy to assign sonic to sonic.name

    tails.marks = 56;
    tails.fav = 't';
    tails.id = 2;

    knuckles.marks = 12;
    knuckles.fav = 'n';
    knuckles.id = 3;

    printf("Sonic got %d marks\n", sonic.marks);
    printf("Tails got %d marks\n", tails.marks);
    printf("KNUCKLES got %d marks\n", knuckles.marks);
    puts(sonic.name); // printing name of sonic
    return 0;
}
