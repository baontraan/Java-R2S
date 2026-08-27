#include <stdio.h>

int main()
{

    // a)

    for (int i = 1; i <= 5; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            printf("%d", j);
        }
        printf("\n");
    }

    // Khởi tạo vòng for I, gán i = 1, điều kiện lặp <=5
    // Sau đó chạy vào for J, gán j = 1, điều kiện lặp < i
    // Nếu true chạy vào lên printf j, sau đó tăng j lên 1 đơn vị
    // Lúc này quay lại kiểm tra điều kiện thấy false, thoát for J, chạy xuống printf của for I
    // Quay lại for I, tăng i lên 1 đơn vị, xét điều kiện thấy true chạy tiếp vào For J

    // b)

    for (int i = 5; i >= 1; i--)
    {
        for (int j = 1; j <= i; j++)
        {
            printf("%d", j);
        }

        printf("\n");
    }
}