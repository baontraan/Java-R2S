#include <stdio.h>

int main()
{
    char input;

    printf("User input: ");
    scanf("%c", &input);

    switch (input)
    {
    case 'B':
    case 'b':
        printf("Basic");
        break;

    case 'C':
    case 'c':
        printf("Cobol");
        break;

    case 'F':
    case 'f':
        printf("Fortran");
        break;

    case 'P':
    case 'p':
        printf("Pascal");
        break;

    case 'V':
    case 'v':
        printf("Visual C++");
        break;

    default:
        printf("Invalid Value !!!");
        break;
    }
}