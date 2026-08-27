#include <stdio.h>

#define SIZE 100

int main()
{
    int n, arr[SIZE], count = 0;

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
    // 0 -5 -11 -4 10 13

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

    // Đếm số lượng phần tử < 0

    for (int i = 0; i < n; i++)
    {
        if (arr[i] < 0)
            count++;
    }

    count > 0 ? printf("Co %d phan tu trong mang > 0", count) : printf("Khong co phan tu nao trong mang co gia tri > 0");
}