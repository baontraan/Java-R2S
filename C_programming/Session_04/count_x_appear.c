#include <stdio.h>

#define SIZE 100

int main()
{
    int n, arr[SIZE], x, count = 0;

    do
    {
        printf("Nhap vao so luong phan tu trong mang (2 - 100): ");
        scanf("%d", &n);

        if (n < 2)
        {
            printf("Gia tri nhap vao khong hop le. Vui long nhap lai !!!\n");
        }
    } while (n < 2);

    // Nhập phần tử
    // 1 1 -5 6 7 -9

    for (int i = 0; i < n; i++)
    {
        printf("Nhap vao phan tu thu %d: ", i);
        scanf("%d", &arr[i]);
    }

    // Xuất phần tử

    printf("Cac phan tu trong mang la: ");

    for (int i = 0; i < n; i++)
    {
        printf("%1d ", arr[i]);
    }

    printf("\n");

    // Đếm số lần xuất hiện của phần tử x

    printf("Nhap vao phan tu can dem so lan xuat hien trong mang: ");
    scanf("%d", &x);

    for (int i = 0; i < n; i++)
    {
        if (arr[i] == x)
            count++;
    }

    count > 0 ? printf("Phan tu %d xuat hien %d lan trong mang", x, count) : printf("Phan tu %d khong ton tai trong mang", x);
}