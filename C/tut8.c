#include <stdio.h>
//ARRAYS
int main(int argc, char const *argv[])
{
    int marks[4] ={2,3,4,5}; // DECLARATION WITH INITIALIZATION
    // marks[0] =34;
    // marks[1] =30;
    // marks[2] =31;
    // marks[3] =35;
    // printf("Marks of student 1 is %d\n ", marks[0]);
    // printf("Marks of student 2 is %d\n ", marks[1]);
    // printf("Marks of student 3 is %d\n ", marks[2]);
    // printf("Marks of student 4 is %d\n ", marks[3]);
    // for (int i = 0; i <4; i++)
    // {
    //     printf("Enter the %d element of array\n" , (i+1));
    //     scanf("%d",&marks[i]);
    // }
    
    for (int i = 0; i <4; i++)
    {
        printf("The  %d element of array is %d \n" ,(i+1), marks[i]);
        
    }
    
    return 0;

//disadvantages of array
/*
Poor time complexity of insertion and deletion of memeory
Wastage of memeory
You cannot change the size of array once declared
*/
