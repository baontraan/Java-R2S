#include <stdio.h>

int main()
{
    int num1, num2, min, max;

    printf("Enter num1, num2 (The numbers cannot be equal): ");
    scanf("%d%d", &num1, &num2);

    min = num1 < num2 ? num1 : num2;
    max = num1 > num2 ? num1 : num2;

    printf("Odd numbers from %d to %d is: \n", min, max);

    for (int i = min; i <= max; i++)
    {
        if (i % 2 != 0)
        {
            printf("%d\n", i);
        }
    }
}