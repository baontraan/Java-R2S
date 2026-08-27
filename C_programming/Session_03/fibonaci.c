#include <stdio.h>

int main()
{
    int num;

    printf("Nhap n: ");
    scanf("%d", &num);

    int num1 = 1, num2 = 1, next;

    if (num >= 1)
    {
        printf("%d", num1);
    }

    if (num >= 2)
    {
        printf("%d", num2);
    }

    for (int i = 3; i <= num; i++)
    {
        next = num1 + num2;
        printf("%d", next);
        num1 = num2;
        num2 = next;
    }
}