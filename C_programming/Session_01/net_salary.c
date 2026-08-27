#include <stdio.h>

int main()
{
    const int basic_salary = 12000;
    int HRA = 150, TA = 120, Others = 450;

    const float DA = basic_salary * 0.12;
    const float PF = basic_salary * 0.14;
    const float IT = basic_salary * 0.15;

    float net_salary = basic_salary + DA + HRA + TA + Others - (PF + IT);

    printf("Net salary: %f", net_salary);
}