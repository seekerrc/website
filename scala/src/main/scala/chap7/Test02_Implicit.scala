package chap7

/**
 * 方法可以具有 隐式 参数列表，由参数列表开头的 implicit 关键字标记
 * 如果参数列表中的参数没有像往常一样传递， Scala 将查看它是否可以获得正确类型的隐式值
 * 如果可以，则自动传递。
 * https://docs.scala-lang.org/zh-cn/tour/implicit-parameters.html
 *
 * 一个从类型 S 到类型 T 的隐式转换由一个函数类型 S => T 的隐式值来定义，或者由一个可转换成所需值的隐式方法来定义。
 * 隐式转换在两种情况下会用到：
 * 1)如果一个表达式 e 的类型为 S， 并且类型 S 不符合表达式的期望类型 T。
 * 2)在一个类型为 S 的实例对象 e 中调用 e.m， 如果被调用的 m 并没有在类型 S 中声明。
 * https://docs.scala-lang.org/zh-cn/tour/implicit-conversions.html
 */
object Test02_Implicit {
  def main(args: Array[String]): Unit = {

    val new12 = new MyRichInt(12)
    println(new12.myMax(15))

    // 1. 隐式函数
    implicit def convert(num: Int): MyRichInt = new MyRichInt(num)
    println(12.myMax(15))

    println("============================")
    // 2. 隐式类
    implicit class MyRichInt2(val self: Int) {
      // 自定义比较大小的方法
      def myMax2(n: Int): Int = if ( n < self ) self else n
      def myMin2(n: Int): Int = if ( n < self ) n else self
    }
    println(12.myMin2(15))

    println("============================")
    // 3. 隐式参数
    implicit val str: String = "alice"
//    implicit val str2: String = "alice2"
    implicit val num: Int = 18

    def sayHello()(implicit name: String): Unit = {
      println("hello, " + name)
    }
    def sayHi(implicit name: String = "atguigu"): Unit = {
      println("hi, " + name)
    }
    sayHello
    sayHi

    // 简便写法
    def hiAge(): Unit = {
      println("hi, " + implicitly[Int])
    }
    hiAge
  }
}

// 自定义类
class MyRichInt(val self: Int) {
  // 自定义比较大小的方法
  def myMax(n: Int): Int = if ( n < self ) self else n
  def myMin(n: Int): Int = if ( n < self ) n else self
}
