# scala

## 文档介绍

官网文档：快速入门很简要，代码简短，适合入门；库文档很详尽，适合查字典

视频教程：首推尚硅谷教程，内容详尽程度适中，适合上手，但是笔记只有pdf，很辣眼睛，复习耗时过长

本文存在的意义：学习官网的概念简要介绍，整理尚硅谷视频教程的代码仓库。做一个能快速上手的文档，附带代码

食用方法：课后复习



## scala

Scala是一门多范式的编程语言，设计初衷是要集成面向对象编程和函数式编程的各种特性。

特点：

- 同样运行在JVM上，可以与现存程序同时运行。
- 可直接使用Java类库。
- 同Java一样静态类型。
- 语法和Java类似，比Java更加简洁，表达性更强。
- 同时支持面向对象、函数式编程。
- 比Java更面向对象。

```java
        javac               java
.java --------> .class ----------> run on JVM
.scala -------> .class ----------> run on JVM
        scalac              scala
```

参考资料

- [尚硅谷大数据技术之Scala入门到精通教程](https://www.bilibili.com/video/BV1Xh411S7bP)
- [Scala官网语法速查](https://docs.scala-lang.org/zh-cn/cheatsheets/index.html)
- [Scala官方文档 Tour Of Scala](https://docs.scala-lang.org/zh-cn/tour/tour-of-scala.html)



## 环境

第一步，确定要安装的版本。Scala依赖Java，访问[这里](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html)查看版本依赖。本文仓库选的是java1.8和scala2.12

第二步，安装，查看[官网页面](https://www.scala-lang.org/download/)即可。我选的是直接通过 [IDEA](https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html)安装

测试一下`hello world`吧~

```scala
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello, world!")
  }
}
```









