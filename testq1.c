#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define SIZE 100

void a(int array[], int size);

int b(int array[], int size);

void functest(int count){
    if (--count) {
        printf("Hello !\n");
        functest(count);
    }
}
int main() {
    // q3
    // int a;
    // int *pa = &a;
    // int **ppa = &pa;
    // *pa = 80;
    // printf("%d", a);

    // functest(3);
//     char s[100] = "Good morning";
//     for (char *p = s, *q = s + strlen(s) - 1; p < q; p++, q--) {
//    char temp = *p;
//    *p           = *q;
//    *q           = temp;
//    printf("%s", s);
// int *p;
// *p = 100;
//  int arr[] = {10, 20, 30, 40, 50, 60};
// int *p1 = arr;
// int *p2 = arr + 4;
// p2++;
// int a = *p2 - *p1;
// printf("%d", a);
    //  int *p;
    //  *p = 100;
    //  printf("%d", &p);
//      int *p = NULL;
// int *c = 0;
//     if (*p == *c) printf("Hello");
//     char s[50] = "Hello";
//     int length = 0;
// char *p;
// for (p = s; *p != '\0'; p++) {
//     length++;
// }
// printf("%d", length);
    int *p = 0;
    int **a = &p;
    if (p == 0) printf("Hello");
}
// }

void a(int array[], int size) {
    for (int i = 0; i < size; i++) {
        if (array[i] > 5) printf("%d ", array[i]);
    }
    printf("\n");
}

int b(int array[], int size) {
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (array[i] % 2 == 1) count++;
    }
    return count;
}