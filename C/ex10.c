#include <stdio.h>
int r1, c1, r2, c2;

void multiply(int a[r1][c1], int b[r2][c2])
{

    int x[r1][c2];
    int r[c1];
    int c[r2];
    // Initializing new matrix a null matrix
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            x[i][j] = 0;
        }
    }

    // MUltiplication process
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            //Loop for extracting each row and corresponding columns of 2 matrices
            for (int k = 0; k < c1; k++)
            {

                r[k] = a[i][k];
                c[k] = b[k][j];
            }

            //Loop for multiplication
            for (int k = 0; k < c1; k++)
            {

                x[i][j] += r[k] * c[k];
            }
        }
    }

//Printing new matrix
    printf("New Matrix is \n");

    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            printf("%d\t", x[i][j]);
        }
        printf("\n");
    }
}

int main(int argc, char const *argv[])
{

    // FIRST MATRIX
    printf("Enter number of rows and columns in first matrix\n");
    scanf("%d", &r1);
    scanf("%d", &c1);
    int a[r1][c1];
    printf("Enter %d elements of first matrix\n", r1 * c1);
    for (int i = 0; i < r1; i++)
    {
        for (int j = 0; j < c1; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }

    // SECOND MATRIX
    printf("Enter number of rows and columns in second matrix\n");
    scanf("%d", &r2);
    scanf("%d", &c2);
    int b[r2][c2];
    printf("Enter %d elements of second matrix\n", r2 * c2);
    for (int i = 0; i < r2; i++)
    {
        for (int j = 0; j < c2; j++)
        {
            scanf("%d", &b[i][j]);
        }
    }

    if (c1 == r2)
    {
        multiply(a, b);
    }
    else
        printf("YOUR MATRIX CANNOT BE MULTIPLIED\n");

    return 0;
}
