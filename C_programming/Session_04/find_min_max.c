#include <stdio.h>

#define SIZE 100

int main()
{
    int n, arr[SIZE];

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

    // Tìm giá trị lớn nhất trong mảng

    int max = arr[0];

    for (int i = 0; i < n; i++)
    {
        if (arr[i] > max)
            max = arr[i];
    }

    printf("Phan tu lon nhat trong mang la: %d\n", max);

    // 1 -5 6 7 -9 10 => max = 10

    // Tìm giá trị nhỏ nhất trong mảng

    int min = arr[0];

    for (int i = 0; i < n; i++)
    {
        if (arr[i] < min)
            min = arr[i];
    }

    printf("Phan tu nho nhat trong mang la: %d\n", min);

    // 1 -5 6 7 -9 10 => min = -9
}