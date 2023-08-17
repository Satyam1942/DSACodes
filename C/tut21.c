#include <stdio.h>//These are C preprocessors
#include <stdlib.h>//Angle brackets  say to look in standard system directories
//#include "tut1.c" // Commas say to look in  current directory . 
//We can include all functions of this file in this file
#define PI 3.14 // define is used to declare preprocessor variables
#define DEBUG /*define is also use in debugging*/
//FUNCTIONS CREATED USING #define are called macros. They are fast

//MACROS
#define SQUARE(r) r*r
/*
PRE DEFINED MACROS
1.__DATE__ --> to get current date as character literal  in MMM DD YYYY format
2.__TIME__ --> to get time  as character literal in "HH:MM:SS format"
3. __LINE__  the current line number as a decimal constant
4.__FILE__ the current filename in string literal
5.__STDC__ defined as one when compiler compiles with the ANSI standard
*/

/*
some c preprocessors are 
#include
#define
#undef
#ifdef
#ifndef
#if
#else
#elif
#pragma -->to issue some special commands to compiler 
*/
int main(int argc, char const *argv[]) // main is already defined in tut1.c
{
    int r =4;
printf("The area of circle is %f\n",PI*SQUARE(r));    
printf("FILE NAME IS %s\n",__FILE__); //To get file name
printf("Today's Date is %s\n",__DATE__);
printf("Time is %s\n", __TIME__);
printf("Line No is  %d\n", __LINE__);
printf("ANSI  %d\n", __STDC__);
    return 0;
}
