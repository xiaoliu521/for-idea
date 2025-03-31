#include <stdio.h>
#define ADJUST 7.31
int main()
{
    const double SCALE = 0.333;
    double shoe, foot;
    shoe = 9.0;
    foot = SCALE * shoe + ADJUST;
    printf("Shoe size (men's)    foot length\n");
    printf("%10.1f %15.2f inches\n", shoe, foot);

    const double SCALE2 = 0.333;
    double shoe2, foot2;
    shoe2 = 3.0;
    while (shoe2 < 18.5) {
       foot2 = SCALE2 * shoe2 + ADJUST;
       printf("%10.1f %15.2f inches\n", shoe2, foot2);
       shoe2 = shoe2 + 1.0; 
    }
    printf("If the shoe fits, wear it.\n");
    return 0;
}
