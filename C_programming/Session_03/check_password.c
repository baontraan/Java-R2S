#include <stdio.h>

int main()
{
    const int password = 12345;

    int user_input;
    int count = 0;

    do
    {

        printf("Enter password: ");
        scanf("%d", &user_input);

        if (user_input != password)
        {
            printf("Invalid password !!!\n");
            count++;

            if (count == 3)
            {
                printf("Too many wrong attempts. Program locked!\n");
                return 0;
            }
        }

    } while (user_input != password);
}