#include <stdio.h>

int main()
{
    int num = 100;

    // Cách  1

    // while (num >= 5)
    // {
    //     printf("%d\n", num);
    //     num -= 5;
    // }

    // Cách 2

    for (int i = 100; i >= 5; i -= 5)
    {
        printf("%d\n", i);
    }
}