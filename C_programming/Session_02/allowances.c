#include <stdio.h>

int main()
{
    float salary, total;
    char grade;

    const int gradeA = 300;
    const int gradeB = 200;
    const int gradeOthers = 100;

    printf("Enter salary: ");
    scanf("%f", &salary);

    getchar();

    printf("Enter grade: ");
    scanf("%c", &grade);

    // Cách 1

    // if (grade == 'A')
    // {
    //     total = salary + gradeA;
    // }
    // else if (grade == 'B')
    // {
    //     total = salary + gradeB;
    // }
    // else
    // {
    //     total = salary + gradeOthers;
    // }

    // Cách 2

    switch (grade)
    {
    case 'A':
        total = salary + gradeA;
        break;

    case 'B':
        total = salary + gradeB;
        break;

    default:
        total = salary + gradeOthers;
        break;
    }

    printf("Total = %f", total);
}