#include <stdio.h>
#include <stdbool.h>

#define SIZE 100

// Hàm nhập mảng

void nhapMang(int a[], int *n)
{
    do
    {
        printf("Nhap so luong phan tu mang: ");
        scanf("%d", n);

        if (*n < 1 || *n > 100)
            printf("So luong phan tu khong hop le. Vui long nhap lai\n");

    } while (*n < 1 || *n > 100);

    for (int i = 0; i < *n; i++)
    {
        printf("Nhap phan tu thu %d: ", i);
        scanf("%d", &a[i]);
    }
}

// Xuất mảng

void xuatMang(int a[], int n)
{

    if (n == 0)
    {
        printf("Mang dang rong. Vui long nhap phan tu cho mang");
        return;
    }

    printf("\nMang vua nhap la: ");

    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }

    printf("\n");
}

// Sắp xếp phần tử mảng giảm dần

void sapXepGiam(int a[], int n)
{
    if (n == 0)
    {
        printf("Mang dang rong. Vui long nhap phan tu cho mang");
        return;
    }

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (a[i] < a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    printf("Mang sau khi sap xep giam dan la: ");

    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }

    printf("\n");
}

// Kiểm tra mảng toàn lẻ

void kiemTraToanLe(int a[], int n)
{
    if (n == 0)
    {
        printf("Mang dang rong. Vui long nhap phan tu cho mang");
        return;
    }

    bool kt = true;

    for (int i = 0; i < n; i++)
    {
        if (a[i] % 2 == 0)
        {
            kt = false;
            break;
        }
    }

    kt ? printf("Tat ca cac phan tu trong mang deu la so le.\n") : printf("Tat ca cac phan tu trong mang khong hoan toan la so le.\n");
}

// Tim kiem 1 gia tri va dem so lan xuat hien

void timKiem(int a[], int n)
{
    if (n == 0)
    {
        printf("Mang dang rong. Vui long nhap phan tu cho mang");
        return;
    }

    int x;
    printf("Nhap vao gia tri x can tim: ");
    scanf("%d", &x);

    int count = 0;

    for (int i = 0; i < n; i++)
    {
        if (a[i] == x)
        {
            count++;
        }
    }

    count > 0 ? printf("Phan tu %d xuat hien %d lan trong mang.\n", x, count) : printf("Phan tu %d khong ton tai trong mang.\n", x);
}

// Kiểm tra số nguyên tố

bool kiemTraNguyenTo(int n)
{
    if (n < 1)
        return false;

    for (int i = 2; i < n; i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}

// Hiển thị số nguyên tố có trong mảng

void hienThiSoNguyenTo(int a[], int n)
{
    if (n == 0)
    {
        printf("Mang dang rong. Vui long nhap phan tu cho mang");
        return;
    }

    bool kt = false;

    printf("Cac phan tu la so nguyen to trong mang: ");

    for (int i = 0; i < n; i++)
    {
        if (kiemTraNguyenTo(a[i]))
        {
            printf("%d ", a[i]);
            kt = true;
        }
    }

    if (!kt)
    {
        printf("Khong co so nguyen to nao trong mang");
    }
    printf("\n");
}

int main()
{
    int a[SIZE], chucNang, n = 0;

    while (1)
    {
        system("cls");
        printf("\n================ MENU ================\n");
        printf("1 - Nhap mang (Input the array)\n");
        printf("2 - Xuat mang (Output the array)\n");
        printf("3 - In mang giam dan (Print in descending order)\n");
        printf("4 - Kiem tra mang toan le (Check if all are odd)\n");
        printf("5 - Tim kiem gia tri (Search a value)\n");
        printf("6 - Hien thi so nguyen to (Display prime numbers)\n");
        printf("7 - Thoat (Quit)\n");
        printf("======================================\n");
        printf("Lua chon cua ban (1-7): ");
        scanf("%d", &chucNang);

        switch (chucNang)
        {
        case 1:
            nhapMang(a, &n);
            break;

        case 2:
            xuatMang(a, n);
            fflush(stdin);
            getchar();
            break;

        case 3:
            sapXepGiam(a, n);
            fflush(stdin);
            getchar();
            break;

        case 4:
            kiemTraToanLe(a, n);
            fflush(stdin);
            getchar();
            break;

        case 5:
            timKiem(a, n);
            fflush(stdin);
            getchar();
            break;

        case 6:
            hienThiSoNguyenTo(a, n);
            fflush(stdin);
            getchar();
            break;

        case 7:
            break;

        default:
            printf("Lua chon khong hop le. Vui long nhap lai");
            fflush(stdin);
            getchar();
            break;
        }

        printf("\n Chuong trinh da ket thuc");
        break;
    }
}