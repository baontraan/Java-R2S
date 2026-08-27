#include <stdio.h>

int main()
{
    int num1, num2, multiply;

    printf("Nhap vao 2 so nguyen: ");
    scanf("%d%d", &num1, &num2);

    multiply = num1 * num2;

    // if (multiply >= 1000)
    // {
    //     printf("Multiply = %d. Tich cua 2 so lon hon hoac bang 1000", multiply);
    // }
    // else
    // {
    //     printf("Multiply = %d. Tich cua 2 so khong lon hon hoac bang 1000", multiply);
    // }

    // Cách 2: Toán tử 3 ngôi

    multiply >= 1000 ? printf("Multiply = %d. Tich cua 2 so lon hon hoac bang 1000", multiply) : printf("Multiply = %d. Tich cua 2 so khong lon hon hoac bang 1000", multiply);
}
