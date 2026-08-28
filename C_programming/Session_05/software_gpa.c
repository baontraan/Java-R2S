#include <stdio.h>

float diemDB = -1;
float diemC = -1;
float diemOOP = -1;
float diemJava = -1;
float gpa = -1;

// Show Menu

void menu()
{
    printf("\n--- GPA MANAGEMENT---\n");
    printf("1. Input mark\n");
    printf("2. Display GPA\n");
    printf("3. Display Rank\n");
    printf("4. Quit\n");
}

// Check grade

float checkGrade()
{
    float grade;

    while (1)
    {
        if (scanf("%f", &grade) == 1)
        { // Kiểm tra kiểu dữ liệu nhập vào có phải kiểu số ko ?
            if (grade >= 0 && grade <= 10)
            {
                return grade;
            }
        }
        else
        {
            while (getchar() != '\n')
                ;
        }

        printf("Diem khong hop le. Vui long nhap lai so tu 0 den 10: ");
    }
}

// Input grade

void intputGrade()
{
    printf("\n--- NHAP DIEM CAC MON HOC (THANG DIEM 10) ---\n");

    printf("Nhap diem mon Database: ");
    diemDB = checkGrade();

    printf("Nhap diem mon C Programming: ");
    diemC = checkGrade();

    printf("Nhap diem mon OOP: ");
    diemOOP = checkGrade();

    printf("Nhap diem mon Java: ");
    diemJava = checkGrade();

    printf("\n[Thong bao] Da luu diem thanh cong!\n");
}

// Calculate GPA

float calculateGPA()
{
    float avg_grade = (diemDB + diemC + diemOOP + diemJava) / 4.0;
    gpa = (avg_grade / 10.0) * 4.0;

    return gpa;
}

// Show GPA

void showGPA()
{
    printf("\n--- GPA GRADE ---\n");
    printf("Your GPA is: %.2f\n", gpa);
}

// Show Rank

void showRank()
{
    printf("\n--- RANK ---\n");
    printf("GPA: %.2f -> Rank: ", gpa);

    if (gpa >= 3.60 && gpa <= 4.00)
    {
        printf("Excellent\n");
    }
    else if (gpa >= 3.20)
    {
        printf("Good\n");
    }
    else if (gpa >= 2.50)
    {
        printf("Fair\n");
    }
    else if (gpa >= 2.00)
    {
        printf("Average\n");
    }
    else
    {
        printf("Weak\n");
    }
}

int main()
{
    int choice;

    while (1)
    {
        menu();
        printf("Enter your choice (1 - 4): ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            intputGrade();
            calculateGPA();
            break;
        case 2:
            if (gpa == -1)
            {
                printf("\n[Loi] Ban chua nhap diem. Vui long chon 1 de nhap diem truoc!\n");
            }
            else
            {
                showGPA();
            }
            fflush(stdin);
            getchar();
            break;
        case 3:
            if (gpa == -1)
            {
                printf("\n[Loi] Ban chua nhap diem. Vui long chon 1 de nhap diem truoc!\n");
            }
            else
            {
                showRank();
            }
            fflush(stdin);
            getchar();
            break;
        case 4:
            printf("\nChuong trinh ket thuc.\n");
            return (0);
        default:
            printf("\n[Loi] Lua chon khong hop le. Vui long chon lai tu 1 den 4.\n");
            fflush(stdin);
            getchar();
            break;
        }
        printf("\n===================================\n");
    }
}