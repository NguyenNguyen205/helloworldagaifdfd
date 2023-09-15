#include <stdio.h>

int main() {
    int a = 6;
    switch (a)
    {
    case 1 ... 4:
        printf("Hello world");
        break;
    
    case 5 ... 100:
        printf("Again");
        break;

    default:
        break;
    }

    int i;
    for (i = 0; i < 100; i++) {

    }
    printf("%d", i);

    
    
}