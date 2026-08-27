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
    // 0 15 30 45 11 12

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

    // Xuất các phần tử chia hết cho 3 và 5
    printf("Cac phan tu chia het cho 3 va 5 la: ");

    for (int i = 0; i < n; i++)
    {
        if (arr[i] % 3 == 0 && arr[i] % 5 == 0)
            printf("%d ", arr[i]);
    }
}