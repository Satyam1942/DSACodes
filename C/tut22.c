//FILES IN C
//FILE I/O 
/*
Files are used to store data and information and access them anytime
example creating save file in video game 
Volatile memory                             Non volatile memory
storage till power is on (RAM)              storage even if power is off  (HDD/SSD)
temporary memory                            permanent memory
Large data can't be stored in RAM             Large data can be stored

Types of files
text file--> can be edited as text
binary file ==> more safe
File operstions
1.creating a new file . 2.Opening a file. 3.Closing a file. 4.Reading and writing file
all functions are included in stdio.h
Creating file
FILE *ptr= NULL;
*ptr = fopen("address to save", "mode") is used. 
mode can be"r" (read) , "w"  (write. anew file is created if it doesn't exist), "rb" (read binary) , "a" (append)
"r+" (open text file for both reading and writing. substitutes letter from beginning), 
"w+" (both reading and writing . first truncates the file to 0 length otherwise creates new file)
"a+"  ( ,,,,,,,,,   keeps the file from before. adds at end)
opened file has to be closed by using fclose() takes file pointer.
To read a file we use fscnaf(file pointer , "%s"(format specifer), string/int depending on format specifier);
Writing a file we use fprintf(file pointer , "%s"(format specifier), string/int depending on format specifier )
*/


//OTHER FUNCTIONS
/* c means character and s means string
fputc --> to insert character  syntax:  int fputc(character , file pointer) on failure returns EOF (end of file)
fputs --> to insert string  int fputs(string , file pointer) 
fgetc---> to read character int fgetc(file pointer) on failure returns EOF
fgets----> to read  string  int fgets(string , int n ,file pointer) [n means number of characters to read including null character] 

*/
//CODE BEGINS HERE
#include <stdio.h>
int main(int argc, char const *argv[])
{
  FILE *ptr =NULL;
  char string[64] = "this content is produced by tut22.c";

//****************READING A FILE****************
//   ptr= fopen("myfile.txt","r");
// fscanf(ptr, "%s",string);
// printf("The content of this file  has %s\n",string);


//*********************WRITING A FILE***************
    ptr = fopen("myfile.txt","w+"); 
    //in append mode it does not delete original content
    //but inwrite mode it deleteds all contents and rewrites from start
    //fprintf(ptr,"%s",string);

    //***************fgetc*************************
  //    char c  = fgetc(ptr);
  //    printf("The character i read was %c\n",c);
  // c = fgetc(ptr);
  // printf("the character i read was %c\n", c);
  // fclose(ptr);

  //****************fgets***************
  // char str[34];
  // fgets(str,30,ptr);
  // printf("String is  %s\n", str);
 
//********************fputc*****************
// w mode clears only once at first when any function writes it 
fputc('o',ptr);
fputs("This is sonic" ,ptr);

//USE THIS TO MAKE AUTOMATED RECIEPT GENERATOR    
    
    return 0;
}
