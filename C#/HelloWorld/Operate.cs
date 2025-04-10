using System;
using System.Collections.Generic;
using System.Linq;
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
            Console.WriteLine("{}, {1}", name1, age1); // 占位符


        }
    }
}
