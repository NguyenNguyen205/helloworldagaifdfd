#include <stdio.h>

int main() {
    char input;
    printf("Enter an alphanumberical character: ");
    scanf("%c", &input);

    if (input >= '0' && input <= '9') {
        printf("It is a numerical character %c \n", input);
    }
    else if (input >= 'a' && input <= 'z') {
        printf("It is a lowercase character %c \n", input);
        printf("> Converted character: %c \n", input - 32);
    }
    else if (input >= 'A' && input <= 'Z') {
        printf("It is a uppercase character %c \n", input);
        printf("> Converted character: %c \n", input + 32);
    }
    else {
        printf("Invalid character");
    }


}