#include <stdio.h>
#include <string.h>
#define DENSITY 62.4 // 人体密度 

int main() {
    float weight, volume; // 重量和体积
    int size, letters; // 尺寸和字母数
    char name[40]; // 姓名

    printf("Hi! What's your first name?\n"); // 提示输入姓名
    scanf("%s", name); // 输入姓名
    printf("%s, what's your weight in pounds?\n", name); // 提示输入重量
    scanf("%f", &weight); // 输入重量
    size = sizeof(name); // 计算姓名的长度
    letters = strlen(name); // 计算姓名中的字母数
    volume = weight / DENSITY; // 计算体积
    printf("Well, %s, your volume is %2.2f cubic feet.\n", name, volume); // 输出体积
    printf("Also, your first name has %d letters,\n", letters); // 输出字母
    // 输出尺寸
    printf("and we have %d bytes to store it.\n", size);
    getchar(); // 不希望执行的窗口立即结束
    getchar(); // 不希望执行的窗口立即结束，否则会自动关闭，需要手动按回车才能看到结果，很不yo
    getchar();
    getchar();
    return 0;
}