package main.scala.chap1

/**
 * 变量
 */
object Test02_Variable {
  def main(args: Array[String]): Unit = {
    // 声明变量
    var a: Int = 10
    // 常量
    val b: Int = 12
    
    //（1）类型可以省略，编译器自动推导，即类型推导
    var a1 = 10

    //（2）类型确定后，就不能修改，说明Scala是强数据类型语言。
    var a2 = 15    // a2类型为Int
    //    a2 = "hello"

    //（3）必须要有初始值
    //    var a3: Int
    
    var alice = new Student("alice", 20)
    alice = new Student("Alice", 20)
    alice = null
    val bob = new Student("bob", 23)
    bob.age = 24
    bob.printInfo()
    //    bob = new Student("bob", 24)
  }
  
}
