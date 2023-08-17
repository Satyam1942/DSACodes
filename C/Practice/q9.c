//MAZE PROBLEM
/*
S = start 
D =destination 
. = walls
* = path

*/

#include<stdio.h>

void solve_maze(char arr[6][5] , int sx , int sy , int dx ,int dy)
{

}



int main(int argc, char const *argv[])
{
    char arr[6][5];
    int dx ,dy, sx ,sy;
//MAZE  INPUT
for(int i = 0 ; i<6;i++)
{
    for(int j = 0 ; j<5;j++)
    {
        scanf("%c", &arr[i][j]);
        if(arr[i][j] == 'S')
        {
            sx = i;
            sy= j;
        }
        if(arr[i][j] == 'D')
        {
            dx = i;
            dy = j;
        }


    }
}




solve_maze(arr, sx,sy, dx ,dy);


}
