#include <stdio.h>
#include <math.h>

int main()
{
    float canhA, canhB, canhC, semi_perimeter, area;

    printf("Enter size length of triangle: ");
    scanf("%f%f%f", &canhA, &canhB, &canhC);

    semi_perimeter = (canhA + canhB + canhC) / 2;
    area = sqrt(semi_perimeter * (semi_perimeter - canhA) * (semi_perimeter - canhB) * (semi_perimeter - canhC));

    printf("Semiperimeter = %f\n", semi_perimeter);
    printf("Area = %f", area);
}