#include <stdio.h>
#include <stdbool.h>

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

    // Kiểm tra tất cả phần tử trong mảng có phải số lẻ ko ?

    bool kt = true;

    for (int i = 0; i < n; i++)
    {
        if (arr[i] % 2 == 0)
            kt = false;
    }

    kt ? printf("Tat ca phan tu trong mang deu la so le") : printf("Tat ca phan tu trong mang khong hoan toan la so le");

    // 1 3 5 7 9 11 => test case 1
    // 1 3 5 7 8 11 => test case 2
}