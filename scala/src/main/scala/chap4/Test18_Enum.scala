package chap4

/**
 * 常量最佳代码风格：枚举
 */
object Test18_Enum {
  def main(args: Array[String]): Unit = {
    // 测试枚举类
    println(WorkDay.MONDAY)
  }
}

// 定义枚举类对象
object WorkDay extends Enumeration {
  val MONDAY = Value(1, "Monday")
  val TUESDAY = Value(2, "TuesDay")
}

// 定义应用类对象
object TestApp extends App {
  println("app start")
  // 类别名 type alias
  type MyString = String
  val a: MyString = "abc"
  println(a)
}