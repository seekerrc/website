package chap3

/**
 * 传名参数,仅在被使用时触发实际参数的求值运算
 * 传名参数的优点是，如果它们在函数体中未被使用，则不会对它们进行求值。 另一方面，传值参数的优点是它们仅被计算一次。
 * 如果参数是计算密集型或长时间运行的代码块，如获取 URL，这种延迟计算参数直到它被使用时才计算的能力可以帮助提高性能。
 * https://docs.scala-lang.org/zh-cn/tour/by-name-parameters.html
 */
object Test11_ByNameParameter {
  def main(args: Array[String]): Unit = {
    // 1. 传值参数
    def f0(a: Int): Unit = {
      println("a: " + a)
    }
    f0(23)
    def f1(): Int = {
      println("f1调用")
      12
    }
    f0(f1())

    println("========================")
    // 2. 传名参数，传递的不再是具体的值，而是---代码块---
    def f2(a: =>Int): Unit = {
      println("a: " + a)
    }
    f2(23)
    f2(f1())
    f2({
      println("这是一个代码块")
      29
    })
  }
}
