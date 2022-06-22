package chap6

/**
 * Test04可以简化为case class
 * 案例类（case classes）的匹配
 * 案例类非常适合用于模式匹配。
 * 在实例化案例类Book时，并没有使用关键字new，这是因为案例类有一个默认的apply方法来负责对象的创建。
 * 当你创建包含参数的案例类时，这些参数是公开（public）的val
 * 案例类在比较的时候是按值比较而非按引用比较
 */
object Test05_MatchCaseClass {
  def main(args: Array[String]): Unit = {
    val student = Student1("alice", 18)
    // 针对对象实例的内容进行匹配
    val result = student match {
      case Student1("alice", 18) => "Alice, 18"
      case _ => "Else"
    }
    println(result)
  }
}

// 定义样例类
case class Student1(name: String, age: Int)