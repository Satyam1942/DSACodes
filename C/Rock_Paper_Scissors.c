// QUESTION
/*
By using  stdlib.h and time.h generate random number by
srand(time(NULL)); srand takes seed as an input and is defined in stlib.h
rand()%n; where n is maximum limit to  generate number

Player 1: you;
Player2: CPU;
Make rock paper scissor game
Give score to both computer and player
Display name of winner at the end
Take input name of the player.
*/

// SOLUTION
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

int genRand()
{
    srand(time(NULL));
    int ch_cpu = rand() % 3;
    if (ch_cpu == 0)
        printf("CPU chose rock \n");
    if (ch_cpu == 1)
        printf("CPU chose paper\n");
    if (ch_cpu == 2)
        printf("CPU chose scissors\n");

    return ch_cpu;
}

int main(int argc, char const *argv[])
{
    char name[34];
    char choice[34];
    int ch_player;
    int ch_cpu;
    int s_player = 0;
    int s_cpu = 0;
    int n;

 start:   

    printf("WELCOME TO ROCK , PAPER AND SCISSORS GAME\n\n");
    // Getting name from player
    printf("ENTER NAME OF PLAYER \n");
    gets(name);
    
    printf("\nEnter the number of rounds you want to play\n");
    scanf("%d", &n);
    fflush(stdin);

    for (int i = 0; i < n; i++)
    {
        printf("\nROUND %d\n", i + 1);
        printf ("\nCurrent Score of %s is %d \n",name, s_cpu);
        printf ("Current Score of CPU is %d \n", s_cpu);
        
        
        // Getting choice from player
        input:
        printf("\nEnter rock , paper or scissors \n ");
        gets(choice);

        // converting string choice of player into integer choice
        // strcasecamp ignores case and compares string
        if (strcasecmp(choice, "rock") == 0)
            ch_player = 0;
        else if (strcasecmp(choice, "paper") == 0)
            ch_player = 1;
        else if (strcasecmp(choice, "scissors") == 0)
            ch_player = 2;
        else
        {
            printf("Wrong Input Try Again!!");
            goto input;
        }

        // Getting input from cpu
        ch_cpu = genRand();
          

        // Check who wins
        if (ch_player == ch_cpu)
        {
            printf("This round is  a tie . Both player get one point\n");
            s_cpu++;
            s_player++;
          
            continue;
        }
        else if ((ch_player == 0 && ch_cpu == 2) || (ch_player == 2 && ch_cpu == 1) || (ch_player == 1 && ch_cpu == 0))
        {
            printf("%s wins round %d and gets 2 points\n", i+1,name);
            s_player += 2;
           
            continue;
        }
        else
        {
            printf("CPU wins round  %d and gets 2 points\n" , i+1);
            s_cpu += 2;
           
            continue;
        }
       
    }

//DISPLAYING RESULTS
        printf("\nRESULTS:\n");
        printf("SCORE of %s is %d\n",name, s_player);
        printf("SCORE of CPU is %d\n",s_cpu);

    if (s_cpu == s_player)
        printf("\nGAME IS TIE\n");
    else if (s_cpu > s_player)
        printf("\nCPU WINS\n");
    else
        printf("\n%s WINS\n", name);


printf("\nWrite 0 to exit and any other number to continue\n\n");


int ipt;
scanf("%d",&ipt);
fflush(stdin);

if(ipt==0)
{
return 0;
}
else
{
    s_cpu =0;
    s_player =0;
    
goto start;
}
}
