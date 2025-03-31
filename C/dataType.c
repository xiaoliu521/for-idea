#include <stdio.h>

int main() {
    int a = 10, b = 20, c; // 定义三个整数变量 a, b, c，并初始化 a 和 b 的值

    int d = 0x12; // 定义一个十六进制整数变量 d，并初始化其值为 0x12
    
    printf("a = %d, octal= %o, hex = %x\n", a, a, a); // 输出变量 a 的值及其对应的八进制和十六进制表示
    printf("dec = %d, octal= %#o, hex = %#x\n", d, d, d); // 输出变量 d 的值及其对应的八进制和十六进制表示，包括前缀 0 和 0x

    float weight; // 体重变量，单位为公斤
    float height; // 身高变量，单位为米
    float bmi;    // BMI 变量

    // 输入身高和体重
    printf("请输入您的身高（米）: ");
    scanf("%f", &height);
    printf("请输入您的体重（公斤）: ");
    scanf("%f", &weight);

    // 计算 BMI
    bmi = weight / (height * height);

    // 输出结果
    printf("您的 BMI 指数为: %.2f\n", bmi);

    // 根据 BMI 值给出建议
    if (bmi < 18.5) {
        printf("您的体重过轻。\n"); 
    } else if (bmi >= 18.5 && bmi < 24.9) {
        printf("您的体重正常。\n"); 
    } else if (bmi >= 24.9 && bmi < 29.9) {
        printf("您的体重过重。\n"); 
    } else {
        printf("您的体重肥胖。\n"); 
    }

    getchar(); // 不希望执行的窗口立即结束
    getchar();
    return 0;
}