#include <stdio.h>
#include <math.h>

void f1() {
    float c_temp, f_temp;
    printf("Enter C temperature: ");
    scanf("%f", &c_temp);

    f_temp = c_temp * 9/5 + 32;
    printf("Converter F temperature: %.2f ", f_temp);

}
void f2() {
    int minutes;
    printf("Enter minutes: ");
    scanf("%d", &minutes);
    printf("The hours are %d with the remaining minutes being %d", minutes / 60, minutes % 60);
}

void f3() {
    double x, y;
    printf("Enter x: ");
    scanf("%lf", &x);
    printf("Enter y: ");
    scanf("%lf", &y);
    printf("Debug: %.2f \n", x);
    double z = pow(x,y);
    printf("Power calculation: %.2f", z );

}
void f4() {
    int num;
    printf("Enter num: ");
    scanf("%d", &num);
    int sum = 0;
    while (1) {
        if (num == 0) break;
        sum += num % 10;
        num = num / 10;
    }
    printf("Final result %d", sum);

}
void f5() {
    double vndValue, usdValue;
    double exchangeVal = 23150;
    printf("Enter vnd value: ");
    scanf("%lf", &vndValue);
    printf("Coverted usd value: %.5f", vndValue / exchangeVal);

}

void f6() {
    int asmt1, asmt2, asmt3;
    printf("Enter assigment points: ");
    scanf("%d %d %d", &asmt1, &asmt2, &asmt3);
    printf("Final result is: %.2f", (float) ((asmt1 * 0.3) + (asmt2 * 0.3) + (asmt3 * 0.4)));
}
int main() {
    // f1();
    // f2();
    // f3();
    // f4();
    // f5();
    // f6();
    int ch = getchar();
    printf("%c", ch);
    // putchar(ch);
    
}