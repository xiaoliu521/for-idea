#include <stdio.h>

int main() {
    
    int rv = printf("Hello, World!"); // 打印字符串并返回打印的字符数
    printf("rv = %d\n", rv); // 打印返回值

    getchar(); // 不希望执行的窗口立即结束

    return 0;
}