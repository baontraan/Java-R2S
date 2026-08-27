#include <stdio.h>

int main()
{
    float radius, area, perimeter;
    const float PI = 3.14;

    printf("Enter radius: ");
    scanf("%f", &radius);

    perimeter = 2 * PI * radius;

    area = PI * radius * radius;

    printf("Perimeter = %g\n", perimeter);
    printf("Area = %g\n", area);
}