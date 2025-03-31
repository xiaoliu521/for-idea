#include <stdio.h>

int main() {
    unsigned int a = 3000000000;

    short end = 200;
    long big = 65537;
    long long verybig = 1844674407370955161;

    printf("a = %d\n", a);
    printf("end = %d\n", end);
    printf("big = %ld\n", big);
    printf("verybig = %lld and not %ld\n", verybig, verybig);
    getchar(); // 不希望执行的窗口立即结束
    return 0;
}