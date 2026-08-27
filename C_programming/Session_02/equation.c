#include <stdio.h>
#include <math.h>

int main()
{
    float a, b, c, delta, x1, x2;

    printf("Enter a: ");
    scanf("%f", &a);

    printf("Enter b: ");
    scanf("%f", &b);

    printf("Enter c: ");
    scanf("%f", &c);

    delta = pow(b, 2) - (4 * a * c);

    if (a == 0)
    {
        printf("Phuong trinh tro thanh phuong trinh bac 1\n");

        if (b == 0 && c != 0)
        {
            printf("Phuong trinh vo nghiem\n");
        }
        else if (b == 0 && c == 0)
        {
            printf("Phuong trinh co vo so nghiem\n");
        }
        else
        {
            printf("Phuong trinh co nghiem duy nhat x = -c / b = %f\n", (-c) / b);
        }
    }
    else
    {
        if (delta < 0)
        {
            printf("Phuong trinh vo nghiem");
        }
        else if (delta == 0)
        {
            x1 = x2 = (-b) / (2 * a);
            printf("Phuong trinh co nghiem kep x1 = x2 = %f", x1);
        }
        else
        {
            x1 = ((-b) + sqrt(delta)) / (2 * a);
            x2 = ((-b) - sqrt(delta)) / (2 * a);

            printf("Phuong trinh co 2 nghiem phan biet\n");
            printf("x1 = %f\n", x1);
            printf("x2 = %f\n", x2);
        }
    }
}