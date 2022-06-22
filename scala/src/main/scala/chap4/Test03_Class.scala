package chap4

import scala.beans.BeanProperty

/**
 * 面向对象之封装
 * 成员默认是公有（public）的。使用private访问修饰符可以在类外部隐藏它们。
 */
object Test03_Class {
  def main(args: Array[String]): Unit = {
    // 创建一个对象
    val student = new Student()
//    student.name   // error, 不能访问private属性
    println(student.age)
    println(student.sex)
    student.sex = "female"
    println(student.sex)
  }
}

// 定义一个类
class Student {
  // 定义属性
  private var name: String = "alice"
  @BeanProperty
  var age: Int = _
  var sex: String = _
}
