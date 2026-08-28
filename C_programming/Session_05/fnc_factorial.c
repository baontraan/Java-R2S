#include <stdio.h>

// Hàm tính giai thừa

int tinhGiaiThua(int n)
{
    while (n <= 0)
    {
        printf("Nhap so nguyen bat ky (n > 0): ");
        scanf("%d", &n);
    }

    int gt = 1;
    for (int i = 1; i <= n; i++)
    {
        gt *= i;
    }

    printf("%d! = %d", n, gt);
    return gt;
}

int main()
{
    int n;
    tinhGiaiThua(n);
}