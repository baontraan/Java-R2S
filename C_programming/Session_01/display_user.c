#include <stdio.h>

int main()
{
    int age;
    float salary;

    printf("Enter age: ");
    scanf("%d", &age);

    printf("Enter salary: ");
    scanf("%f", &salary);

    printf("Your age is: %d\n", age);
    printf("Your salary is: %g\n", salary);
}