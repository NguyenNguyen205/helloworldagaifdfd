#include <stdio.h>


int main () {
    int num;
    printf("Enter a positive integer:");
    scanf("%d", &num);
    int count = 0;
    int sum = 0;
    int mid = 0;
    while (1) {
        if (num == 0) break;
        mid = num % 10;
        if (mid >= 5) {
            count++;
            sum += mid;
        }
        num = num / 10;
    }
    printf("Number of digits >= 5: %d \n", count);
    printf("Their sum is: %d \n", sum);
}