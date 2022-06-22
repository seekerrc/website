package chap4

/**
 * 面向对象之封装
 */
object Test04_Access {
  def main(args: Array[String]): Unit = {
    // 创建对象
    val person: Person = new Person()
    //person.idCard    // error
//    person.name    // error
    println(person.age)
    println(person.sex)
    person.printInfo()

    var worker: Worker = new Worker()
    worker.age = 23
    //worker.idCard = "sdadsa"
    worker.printInfo()
  }
}

// 定义一个子类
class Worker extends Person {
  override def printInfo(): Unit = {
//    println(idCard)    // error
    name = "bob"
    age = 25
    sex = "male"

    println(s"Worker: $name $sex $age")
  }
}

// 定义一个父类
class Person {
  private var idCard: String = "3523566"
  protected var name: String = "alice"
  var sex: String = "female"
  private[chap4] var age: Int = 18
  
  def printInfo(): Unit = {
    println(s"Person: $idCard $name $sex $age")
  }
}