#include <stdio.h>
int main() {
    printf("Hello, World!\n"); 
    int a, b, c;

    int yingcun;
    printf("请输入英寸: ");
    scanf("%d", &yingcun);
    printf("厘米为%f", yingcun * 2.54);
 
    return 0;
}