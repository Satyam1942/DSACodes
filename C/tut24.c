#include <stdio.h>
#include <stdlib.h>
// MEMORY LEAK IN C
/*
memory leak occurs when we dont use dynamic memory allocation properly
When we keep on allocating memory in heap without freeing then this causes memory leak
to avoid memory leak we should free the memory allocated  in heap
*/


//This situation is memory leak situation 
int main(int argc, char const *argv[])
{
    int a, i = 0;
    int *i2;
    while (i < 4555)
    {
        printf("Welcome to code\n");
        i2 = malloc(34444 * sizeof(int));
        if (i % 100 == 0)
        {
            getchar();
        }
        i++;
        //       free(i2);// this will prevent  memory leak situation
    }

    return 0;
}
