package chap2

import scala.collection.immutable

/**
 * for 循环语句
 */
object Test02_ForLoop {
  def main(args: Array[String]): Unit = {
    println("==============use `to` if inclusive=============")
    // 1. 范围遍历
    for (i <- 1 to 5){
      println(i + ". hello world")
    }
    //for (i <- 1.to(5)){
    //  println(i + ". hello world")
    //}

    println("============use `until` if exclusive===============")
    for (i <- 1 until 5){
      println(i + ". hello world")
    }
    //for (i <- Range(1, 5)){
    //  println(i + ". hello world")
    //}

    println("==============================")
    // 2. 集合遍历
    for (i <- Array(12, 34, 53)){
      println(i)
    }
    for (i <- List(12, 34, 53)){
      println(i)
    }
    for (i <- Set(12, 34, 53)){
      println(i)
    }

    println("==========================")
    // 3. 循环守卫
    for (i <- 1 to 5 if i != 5){
      println(i)
    }
    // equals to:
    //for (i <- 1 to 5){
    //  if (i != 5){
    //    println(i)
    //  }
    //}

    println("======================")
    // 4. 循环步长
    for (i <- 13 to 30 by 5){
      println(i)
    }
    println("-------------------")
    for (i <- 5 to 1 by -1){
      println(i)
    }
    //println("-------------------")
    //for (i <- 1 to 5 reverse){
    //  println(i)
    //}
    //println("---------does not have to be int----------")
    //for (data <- 1.0 to 5.0 by 0.9){
    //  println(data)
    //}

    println("===========nested for===========")
    // 5. 循环嵌套
    for (i <- 1 to 3){
      for (j <- 1 to 3){
        println("i = " + i + ", j = " + j)
      }
    }
    println("----------equals to---------")
    for (i <- 1 to 4; j <- 1 to 5){
      println("i = " + i + ", j = " + j)
    }

    println("===========var===========")
    // 6. 循环引入变量
    for (i <- 1 to 5){
      val j = 5 - i
      println("i = " + i + ", j = " + j)
    }
    println("----------equals to---------")
    for (i <- 1 to 5; j = 5 - i){
      println("i = " + i + ", j = " + j)
    }
    //println("----------equals to---------")
    //for {
    //  i <- 1 to 5
    //  j = 5 - i
    //}
    //{
    //  println("i = " + i + ", j = " + j)
    //}

    println("======================")
    // 7. 循环返回值
    val a = for (i <- 1 to 5) {
      i * i
    }
    println("a = " + a)
    val b: immutable.IndexedSeq[Int] = for (i <- 1 to 5) yield i * i
    println("b = " + b)
  }
}
