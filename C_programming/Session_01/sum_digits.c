#include <stdio.h>

int main()
{

    // 123 / 100 = 1(nguyên) => Lấy hàng trăm
    // (123 / 10) = 12(nguyên) % 10 = 2(dư) => Lấy hàng chục
    // 123 % 10 = 3(dư) => Lấy hàng đơn vị

    int number, hundred, ten, unit, sum;

    printf("Enter a number: ");
    scanf("%d", &number);

    hundred = number / 100;
    ten = (number / 10) % 10;
    unit = number % 10;

    sum = hundred + ten + unit;

    printf("Sum of digits: %d", sum);
}