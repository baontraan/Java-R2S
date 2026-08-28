#include <stdio.h>
#include <math.h>

#define PI 3.14

// Hàm tính chu vi hình tròn

float tinhChuViHinhTron(float r)
{
    float chuVi = PI * pow(r, 2);
    return chuVi;
}

// Hàm tính diện tích hình tròn

float tinhDienTichHinhTron(float r)
{
    float dienTich = 2 * PI * r;
    return dienTich;
}

// Hàm nhập bán kính hình tròn và tính toán

void nhapBanKinhHinhTron(float r)
{
    while (r <= 0)
    {
        printf("Nhap ban kinh hinh tron (r > 0): ");
        scanf("%f", &r);
    }

    printf("Chu vi = %f\n", tinhChuViHinhTron(r));
    printf("Dien tich = %f\n", tinhDienTichHinhTron(r));
}

int main()
{

    float r;
    nhapBanKinhHinhTron(r);
}