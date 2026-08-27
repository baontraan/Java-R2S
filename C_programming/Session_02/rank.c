#include <stdio.h>

int main()
{
    float avg_score;
    char grade;

    printf("Enter AVG score: ");
    scanf("%f", &avg_score);

    if (avg_score < 0)
    {
        printf("Invalid AVG score !!!");
        return 0;
    }

    if (avg_score > 75)
    {
        grade = 'A';
    }
    else if (avg_score > 60 && avg_score <= 75)
    {
        grade = 'B';
    }
    else if (avg_score > 45 && avg_score <= 60)
    {
        grade = 'C';
    }
    else if (avg_score > 35 && avg_score <= 45)
    {
        grade = 'D';
    }
    else
    {
        grade = 'E';
    }

    printf("Your AVG score is %f. Grade = %c", avg_score, grade);
}