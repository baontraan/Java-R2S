#include <stdio.h>

int main()
{
    int num = 0;

    while (num < 2 || num > 9)
    {
        printf("Enter a number (between 2 - 9): ");
        scanf("%d", &num);
    }

    printf("\n");

    for (int i = 1; i <= 10; i++)
    {
        printf("%d * %d = %d\n", num, i, num * i);
    }
}