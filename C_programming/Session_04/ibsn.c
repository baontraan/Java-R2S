#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

int main()
{
    int arr[SIZE];
    int luaChon;

    printf("ISBN Validator =================== \n");

    while (1)
    {

        printf("\nBan muon lam gi? (1: Kiem tra ISBN, 0: Thoat chuong trinh): ");
        fflush(stdin);
        scanf("%d", &luaChon);

        if (luaChon == 0)
        {
            break;
        }

        if (luaChon == 1)
        {
            system("cls");
            printf("--- KIEM TRA MA ISBN ---\n");
            printf("Moi nhap 10 chu so (cach nhau bang dau cach):\n");

            for (int i = 0; i < SIZE; i++)
            {
                scanf("%d", &arr[i]);
            }

            // Tính tổng theo công thức
            int tong = 0;
            for (int i = 0; i < 9; i++)
            {
                tong += arr[i] * (10 - i);
            }
            tong += arr[9];

            // In kết quả kiểm tra
            if (tong % 11 == 0)
            {
                printf("\n=> KET QUA: Day la ma ISBN HOP LE.\n");
            }
            else
            {
                printf("\n=> KET QUA: Day KHONG PHAI la ma ISBN hop le.\n");
            }

            printf("\nAn Enter de quay lai menu...");
            fflush(stdin);
            getchar();
        }
    }

    system("cls");
    printf("Have a Nice Day!\n");
    return 0;
}
