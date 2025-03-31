#include <stdio.h>

int main() {
    int n = 4;
    int m = 5;
    float f = 7.0;
    float g = 8.0;

    printf("%d, %d\n", n); // 参数太少
    printf("%d\n", n, m, f); // 参数太多
    printf("%d, %d\n", f, g); // 参数类型不匹配
    getchar(); // 不希望执行的窗口立即结束
    return 0; // 不希望执行的窗口立即结束，否则会自动关闭，需要手动按回车才能看到结果，很不yo
}

/*
    4, 2041696
    4
    0, 0
*/