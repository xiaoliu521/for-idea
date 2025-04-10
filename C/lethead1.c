#include <stdio.h>
#define NAME "Giraffe Academy"
#define ADDRESS "1234 Main Street"
#define PLACE "Giraffe Town"
#define WIDTH 40
#define LENGTH(array) (sizeof(array) / sizeof(array[0]))

typedef unsigned int uint; // new type name for unsigned int
typedef char *p_str; // new type name for char *
typedef int ARRAY[10]; // new type name for int[10]
typedef int *p_int; // new type name for int
//  *

void starbar(void); // prototype

// 声明数组
double balance[5] = {1000.0, 2.0, 3.4, 17.0, 50.0};

int main(void) {
  starbar(); // function call
  printf("%s\n", NAME); // NAME is replaced by "Giraffe Academy"
  printf("%s\n", ADDRESS); // ADDRESS is replaced by "1234 Main Street"
  printf("%s\n", PLACE); // PLACE is replaced by "Giraffe Tow
  starbar(); // function call
  int len = sizeof(balance) / sizeof(balance[0]);
  printf("数组balance的长度为%d\n", len); 
  printf("数组balance的长度为%d\n", LENGTH(balance));
//   int *ptr = &balance[0]; // 指向数组的第一个元素的指针
  
//   printf("数组balance的第一个元素的地址为%p\n", ptr); // 输出数组的第一个元素的地址
//   printf("NULL的地址为%p\n", NULL); // 输出NULL的地址

    // 指针
    int arr[] = {1, 2, 3, 4, 5}; // 定义一个数组
    int *ptr = arr; // 定义一个指针，指向数组的第一个元素
    printf("数组的第一个元素的值为%d\n", *ptr); 
    ptr++; // 指针向后移动一个元素
    printf("数组的第二个元素的值为%d\n", *ptr);
    ptr++; 
    printf("数组的第三个元素的值为%d\n", *ptr);
    ptr++;
    printf("数组的第四个元素的值为%d\n", *ptr);
    ptr++;
    printf("数组的第五个元素的值为%d\n", *ptr);

  getchar();
  return 0; // return 0 to indicate successful exi
}

void starbar(void) { // function definition
    int count;

    for (count = 1; count <= WIDTH; count++)
        putchar('*');
    putchar('\n');
}