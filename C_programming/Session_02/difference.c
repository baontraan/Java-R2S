#include <stdio.h>
#include <math.h>

int main()
{

    int num1, num2, result;

    printf("Nhap vao 2 so nguyen: ");
    scanf("%d%d", &num1, &num2);

    result = abs(num1 - num2);
    // Dùng giá trị tuyệt đối để chạy test case với num1: 10 - 20

    printf("Hieu 2 so nguyen la: %d\n", result);

    if (result == num1)
    {
        printf("Hieu so bang voi gia tri da nhap la num1: %d = %d\n", result, num1);
    }
    else if (result == num2)
    {
        printf("Hieu so bang voi gia tri da nhap la num2: %d = %d\n", result, num2);
    }
    else
    {
        printf("Hieu so khong bang voi bat ky gia tri nao da nhap\n");
    }
}