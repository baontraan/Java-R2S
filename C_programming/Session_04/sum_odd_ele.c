#include <stdio.h>

#define SIZE 100

int main()
{
    int n, arr[SIZE], tong = 0;

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
    // 1 -5 6 7 -9 10

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

    // Tính tổng các số lẻ có trong mảng

    for (int i = 0; i < n; i++)
    {
        if (arr[i] % 2 != 0)
            tong += arr[i];
    }

    printf("Tong cac so le trong mang: %d\n", tong);

    // 1 - 5 + 7 - 9 = -6
}