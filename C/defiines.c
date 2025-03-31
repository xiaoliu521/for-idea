#include <stdio.h>
#include <float.h> // 包含 FLT_MAX 和 DBL_MAX 常量的头文件
#include <limits.h> // 包含 INT_MAX 和 LONG_MAX 常量的头文件


int main() {
    printf("int 类型的最大值为: %d\n", INT_MAX); // 输出 int 类型的最大值
    printf("long 类型的最大值为: %ld\n", LONG_MAX); // 输出 long 类型的最大值
    printf("float 类型的最大值为: %f\n", FLT_MAX); // 输出 float 类型的最大
    printf("MIN_VALUE: %f\n", FLT_MIN); // 输出 float 类型的最小

    getchar(); // 不希望执行的窗口立即结束，等待用户输入字符后继续执行下一行代码，否则程序会立即结束，窗口会立即关闭。
    return 0;

}