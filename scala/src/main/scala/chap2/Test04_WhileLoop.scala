package chap2

/**
 * while loop, not recommended
 */
object Test04_WhileLoop {
  def main(args: Array[String]): Unit = {
    // while
    var a: Int = 5
    while (a >= 1){
      println("this is a while loop: " + a)
      a -= 1
    }

    var b: Int = 0
    do {
      println("this is a do-while loop: " + b)
      b -= 1
    } while (b > 0)
  }
}
