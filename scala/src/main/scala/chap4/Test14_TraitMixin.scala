package chap4

/**
 * 当某个特质被用于组合类时，被称为混入Mixin
 * class D extends B with C
 * 类D有一个父类B和一个混入C。
 * 一个类只能有一个父类但是可以有多个混入（分别使用关键字extends和with）。
 * 混入和某个父类可能有相同的父类。
 */
object Test14_TraitMixin {
  def main(args: Array[String]): Unit = {
    val student = new Student14
    student.study()
    student.increase()
    student.play()
    student.increase()
    student.dating()
    student.increase()

    println("===========================")
    // 动态混入
    val studentWithTalent = new Student14 with Talent {
      override def dancing(): Unit = println("student is good at dancing")
      override def singing(): Unit = println("student is good at singing")
    }

    studentWithTalent.sayHello()
    studentWithTalent.play()
    studentWithTalent.study()
    studentWithTalent.dating()
    studentWithTalent.dancing()
    studentWithTalent.singing()
  }
}

// 再定义一个特质
trait Knowledge {
  var amount: Int = 0
  def increase(): Unit
}

trait Talent {
  def singing(): Unit
  def dancing(): Unit
}

class Student14 extends Person13 with Young with Knowledge {
  // 重写冲突的属性
  override val name: String = "student"

  // 实现抽象方法
  def dating(): Unit = println(s"student $name is dating")

  def study(): Unit = println(s"student $name is studying")

  // 重写父类方法
  override def sayHello(): Unit = {
    super.sayHello()
    println(s"hello from: student $name")
  }

  // 实现特质中的抽象方法
  override def increase(): Unit = {
    amount += 1
    println(s"student $name knowledge increased: $amount")
  }
}