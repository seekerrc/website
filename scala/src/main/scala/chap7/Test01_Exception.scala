package chap7

/**
 * 异常处理，exception模式匹配
 */
object Test01_Exception {
  def main(args: Array[String]): Unit = {
    try{
      val n = 10 / 0
    } catch {
      case e: ArithmeticException => {
        println("发生算术异常")
      }
      case e: Exception => {
        println("发生一般异常")
      }
    } finally {
      println("处理结束")
    }
  }
}