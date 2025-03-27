# java17新特性
1. record
record关键字可以用来声明一个不可变的数据类。自动生成getter、setter、equals、hashCode、toString等方法。

2. instanceof
instanceof关键字可以用来判断一个对象是否是某个类的实例。
在java17中做了增强，允许在一行代码中执行类型检查和变量提取。使得类型检查和转换更加简洁和安全。
```
if (obj instanceof String str) {
    System.out.println(str);
}
```
3. switch


3. 文本块
前后都有三个双引号，中间可以换行。
```
String str = """
    Hello,
    World!
    """;
System.out.println(str);
```
4. 模式匹配

5. java.util包的改进
java.util包中在java17得到了增强，包括map和collection接口的改进。
例如Map接口现在支持foreach方法。
```
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.put("b", 2);
map.forEach((k, v) -> System.out.println(k + "=" + v));
```
还有其他的改进，例如List接口现在支持sublist方法。
```
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");
List<String> subList = list.subList(1, 3);
System.out.println(subList);
```

