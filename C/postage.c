#include <stdio.h>
#include <ctype.h>

int main(){
    const int FIRST_OZ = 46;
    const int NEXT_OZ = 20;
    int ounces;
    int cost;
    printf("ounces, cost\n");
    for (ounces = 1, cost = FIRST_OZ; ounces <= 16; ounces++, cost += NEXT_OZ){
        printf("%d, %d\n", ounces, cost);
    }

    float debts[19];
    // debts[20] = 18.43;
    printf("debts[20] = %.2f\n", debts[20]);

    for (int i = 1; i <= 5; i++){
        for (int j = 1; j <= i; j++){
            printf("$");
        }
        printf("\n");
    }

    getchar(); // wait for user to press a key to clos
    return 0;
}