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

    // Xuất toàn bộ số nguyên tố có trong mảng

    bool has_prime = false;

    for (int i = 0; i < n; i++)
    {
        if (arr[i] >= 2)
        {
            bool kt = true;

            for (int i = 2; i < arr[i]; i++)
            {
                if (arr[i] % i == 0)
                {
                    kt = false;
                    break;
                }
            }

            if (kt)
            {
                printf("%d ", arr[i]);
                has_prime = true;
            }
        }
    }

    if (!has_prime)
        printf("Khong co so nguyen to nao trong mang");
}