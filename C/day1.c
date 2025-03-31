#include<stdio.h>
int main(){
    int dogs;

    printf("Enter the number of dogs: ");
    scanf("%d",&dogs);
    printf("I have %d dogs.\n",dogs);

    getchar(); // 不希望执行的窗口立即结束
    return 0;
}