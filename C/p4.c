#include<stdio.h>
#include<string.h>
#include <math.h>
int main(int argc, char const *argv[])
{

FILE* ptr;
ptr= fopen("trial.txt","r+");
char name[40];

scanf("%s",name);

if(ptr==NULL) {printf("Unable to open file"); return 1;}


while (!feof(ptr))
{
  long pos = ftell(ptr);
  char c = fgetc(ptr);

  if(c=='+'){
  fseek(ptr,pos,SEEK_SET);    
    fputs(name,ptr);
    break;

  }
fseek(ptr,pos+1,SEEK_SET);
 
 }
fclose(ptr);
return 0;
}
 

