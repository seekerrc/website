package chap6

/**
 * 模式匹配是检查某个值（value）是否匹配某一个模式的机制
 * 一个成功的匹配同时会将匹配值解构为其组成部分
 * 它是Java中的switch语句的升级版
 * 同样可以用于替代一系列的 if/else 语句。
 * https://docs.scala-lang.org/zh-cn/tour/pattern-matching.html
 */
object Test01_PatternMatchBase {
  def main(args: Array[String]): Unit = {
    // 1. 基本定义语法
    val x: Int = 5
    val y: String = x match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case _ => "other"
    }
    println(y)

    // 2. 示例：用模式匹配实现简单二元运算
    val a = 25
    val b = 13
    def matchDualOp(op: Char): Int = op match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case '%' => a % b
      case _ => -1
    }
    println(matchDualOp('+'))
    println(matchDualOp('/'))
    println(matchDualOp('\\'))

    println("=========================")
    // 3. 模式守卫
    // 求一个整数的绝对值
    def abs(num: Int): Int = num match {
        case i if i >= 0 => i
        case i if i < 0 => -i
    }
    println(abs(67))
    println(abs(0))
    println(abs(-24))
  }
}
