using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    /// <summary>
    /// internal 修饰符 表示默认访问权限，只能在当前程序集中访问
    /// </summary>
    internal class Operate
    {

        static void Main()
        {
            int age = 15;
            string name = "xianren";
            Console.WriteLine(name + age);
            Console.WriteLine(10 / 3);
            Console.WriteLine(10.0f / 3);
            int year = 2008;
            Console.WriteLine(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) );

            string name1 = "Mongokey";
            int age1 = 100;
            Console.WriteLine("{0}, {1}", name1, age1); // 占位符


            int c = 10;
            int f = ++c;
            Console.WriteLine(c); // 11 

            // 复合赋值运算符
            int a = 10;
            a += 5; // a = a + 5
            Console.WriteLine(a); // 15
            // 逻辑运算符
            bool b1 = true;
            bool b2 = false;
            Console.WriteLine(b1 && b2); // false

            // 关系运算符
            int x = 10;
            int y = 20;
            Console.WriteLine(x > y); // false
            Console.WriteLine(x < y); // true
            Console.WriteLine(x >= y); // false
            Console.WriteLine(x <= y); // true
            Console.WriteLine(x == y); // false
            Console.WriteLine(x != y); // true

            int nian = 2008;
            if (nian % 400 == 0 || (nian % 4 == 0 && nian % 100 != 0))
            {
                Console.WriteLine("是闰年");
            }
            else
            {
                Console.WriteLine("不是闰年");
            }

            // 占位符
            string name2 = Console.ReadLine();
            int age2 = 100;
            // \t tab 键  \b backspace 退格键 
            Console.WriteLine("{0}, \n{1}", name2, age2); // 占位符


            Console.ReadKey();  

        }
    }
}
