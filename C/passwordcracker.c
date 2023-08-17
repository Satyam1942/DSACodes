#include<stdio.h>
#include<string.h>
void encrypt();
void decrypt();
int main(int argc, char const *argv[])
{

    char response;
    char password[40] ="12345";
    char enteredPassword[40];
    printf("--------------FILE ENCRYPTER/DECRYPTER-------------------\n");
    while(1){
    printf("PRESS E to encrypt a file or D to decrypt a file and Q to quit\n");
    scanf("%c",&response);
    if(response=='E'){
        printf("ENTER PASSWORD\n"); 
    scanf("%s",enteredPassword) ; 
    if(strcmp(enteredPassword,password)==0) 
    encrypt(); 
    else printf("WRONG PASSWORD\n");
    }
     if(response=='D'){
        printf("ENTER PASSWORD\n"); 
    scanf("%s",enteredPassword) ; 
    if(strcmp(enteredPassword,password)==0) 
    decrypt(); 
    else printf("WRONG PASSWORD\n");
    }
    if(response=='Q') break;
    }
   
    
        return 0;
}

void decrypt()
{
  FILE *ptr;
    ptr = fopen("test.txt","r+");
    fseek(ptr,0,SEEK_END);
    long filesize = ftell(ptr);
    rewind(ptr);
    while(filesize--)
    {
        char c = getc(ptr);
        long pos = ftell(ptr);
       
        fseek(ptr,pos-1,SEEK_SET);
        printf("%c",c-1);
        fprintf(ptr,"%c" ,c-1);
        fseek(ptr,pos,SEEK_SET);
        
    }  
    printf("\n");
    fclose(ptr);


}

void encrypt()
{
  FILE *ptr;
    ptr = fopen("test.txt","r+");
    fseek(ptr,0,SEEK_END);
    long filesize = ftell(ptr);
    rewind(ptr);
    while(filesize--)
    {
        char c = getc(ptr);
        long pos = ftell(ptr);
       
        fseek(ptr,pos-1,SEEK_SET);
        printf("%c",c+1);
        fprintf(ptr,"%c" ,c+1);
        fseek(ptr,pos,SEEK_SET);
        
    }  
    printf("\n");
    fclose(ptr);


}
