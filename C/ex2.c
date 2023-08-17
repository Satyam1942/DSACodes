/*
ask user he wants to convert what into what
then ask and display output accordingly
kms to miles
inches to foot
cms to inches
pounds to kgs
inches to metres
*/
#include <stdio.h>
int main(int argc, char const *argv[])
{
    int n,s;
    float val;
    printf("Welcome to Converter\n");
label:

    printf("\nYou can convert the following things\n1. Kms to miles\n  2.Inches to feet\n  3.cms to inches\n  4.pounds to kgs\n  5.inches to metres\n");
    printf("Enter the number corresponding to what you want to convert. Press 0 to exit\n");
    scanf("%d", &n);
    switch (n)
    {
        case 0:
        return 0;
        break;
    case 1:
        printf("Enter the value in  km\n ");
        scanf("%f", &val);
        printf("value in miles is %f \n", 0.621 * val);
        break;
    case 2:
        printf("Enter the value in  Inches\n ");
        scanf("%f", &val);
        printf("value in feet is %f \n", 0.0833 * val);
        break;
    case 3:
        printf("Enter the value in cms  \n ");
        scanf("%f", &val);
        printf("value in inches is %f \n", 0.394 * val);
        break;
    case 4:
        printf("Enter the value in  pounds \n ");
        scanf("%f", &val);
        printf("value in kg is %f \n", 0.454 * val);
        break;
    case 5:
        printf("Enter the value in  inches\n ");
        scanf("%f", &val);
        printf("value in metres is %f \n", 0.0254 * val);
        break;
    default:
        printf("You have entered invalid number. Try again\n");
        goto label;
        break;
    }
    printf("\nWrite 0 to continue and write any other number to exit\n");
    scanf("%d",&s);
    if (s == 0)
    {
        goto label;
    }
    else
        return 0;
}
