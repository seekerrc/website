# scala入门教程，快速上手代码库整理

## 文档介绍

### 资源

1、官网文档

- 快速入门很简要，适合入门
- 库文档过于详尽，适合查字典

2、视频教程，首推尚硅谷教程

- 内容详尽程度适中，适合上手
- 但是笔记只有pdf，很辣眼睛，复习耗时过长

### 本文

整理尚硅谷视频教程的代码仓库

为代码补充简要的注释，注释内容来源于官网权威指南，适合快速上手，不用再读辣眼文档，不懂的查官网链接即可

食用方法：按顺序阅读代码、记忆不清的地方运行或者打断点

- 视频课后即时复习
- 一段时间后重新上手

> 代码行数：3750
>
> 预计阅读时间：1天

### 参考资料

1. [视频教程](https://www.bilibili.com/video/BV1Xh411S7bP?p=1)
2. [Tour of Scala](https://docs.scala-lang.org/zh-cn/tour/tour-of-scala.html)

墙裂推荐：[Scala Cheatsheet](https://docs.scala-lang.org/zh-cn/cheatsheets/index.html) 

## scala

Scala是一门多范式的编程语言，设计初衷是要集成**<u>面向对象编程和函数式编程</u>**的各种特性。

[介绍](https://docs.scala-lang.org/zh-cn/tour/tour-of-scala.html)

特点：

- 静态类型
- 同时支持面向对象、函数式编程
- 比Java更加简洁，表达性更强。比Java更面向对象
- 同样运行在JVM上，可直接使用Java类库

```java
               javac                   java
.java   --------> .class ----------> JVM

             scalac                  scala
.scala --------> .class ---------->JVM
```

## 环境

第一步，确定要安装的版本。Scala依赖Java，访问[这里](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html)查看版本依赖。本文仓库选的是java1.8和scala2.12

第二步，安装，查看[官网页面](https://www.scala-lang.org/download/)即可。我选的是直接通过 [IDEA](https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html)安装

安装完成后，测试一下`hello world`吧~

```scala
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello, world!")
  }
}
```

## 使用本仓库

1、下载

```shell
git clone https://github.com/seekerrc/website.git
```

2、IDEA -> 点击open -> 选择目录website/scala

3、配置java SDK和scala SDK

4、找到hello world文件（scala/src/main/scala/chap1/HelloWorld.scala），右键运行测试一下把

## 代码结构

代码分为7个章节，chap1 to chap7，顺序和内容与[视频教程](https://www.bilibili.com/video/BV1Xh411S7bP?p=1)基本一致，主要做整理和补充说明

| 章节  | 主题             | 内容                                                         |
| ----- | ---------------- | ------------------------------------------------------------ |
| chap1 | 语言基础         | 变量、基本数据类型、字符串、运算符、输入输出                 |
| chap2 | 控制结构         | 条件分支、循环、break跳转                                    |
| chap3 | 函数与方法       | 方法及函数定义、形参实参、Lambda表达式、高阶函数、柯里化、传名参数、懒加载 |
| chap4 | 面向对象         | 包嵌套、包对象、类构造器、封装继承多态三大特性、抽象类、匿名子类、伴生对象、特质、特质混入、自类型、类别判断、枚举 |
| chap5 | 常用集合数据类型 | Array[T]、ArrayBuffer[T]、List[T]、ListBuffer[T]、Set[T]、mutable.Set[T]、Map[K, V]、mutable.Map[K, V]、tuple、集合常用api、mutable.Queue[T]、wordcount案例 |
| chap6 | 模式匹配         | 模式匹配语法、类型匹配、解包、案例类（case classes）匹配、偏函数 |
| chap7 | 其他             | 异常处理、隐式转换、隐式参数、泛型类型变、类型上下界         |





