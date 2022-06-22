package chap5

/**
 * 常用API
 * 归约
 */
object Test15_HighLevelFunction_Reduce {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    // 1. reduce
    println(list.reduce( _ + _ ))
    println(list.reduceLeft(_ + _))
    println(list.reduceRight(_ + _))

    println("===========================")
    val list2 = List(3,4,5,8,10)
    println(list2.reduce(_ - _))    // -24
    println(list2.reduceLeft(_ - _))
    println(list2.reduceRight(_ - _))    // 3 - (4 - (5 - (8 - 10))), 6

    println("===========================")
    // 2. fold
    println(list.fold(10)(_ + _))     // 10 + 1 + 2 + 3 + 4
    println(list.foldLeft(10)(_ - _))    // 10 - 1 - 2 - 3 - 4
    println(list.foldRight(10)(_ - _))    // 1 - (2 - (3 - (4 - 10))),  8
  }
}
