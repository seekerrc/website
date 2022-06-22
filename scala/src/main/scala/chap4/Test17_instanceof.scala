package chap4

/**
 * 类别判断
 * isInstanceOf[]
 * asInstanceOf[]
 * classOf[]
 */
object Test17_Extends {
  def main(args: Array[String]): Unit = {
    // 1. 类型的检测和转换
    val student: Student17 = new Student17("alice", 18)
    student.study()
    student.sayHi()
    val person: Person17 = new Student17("bob", 20)
    person.sayHi()

    // 类型判断
    println("student is Student17: " + student.isInstanceOf[Student17])
    println("student is Person17: " + student.isInstanceOf[Person17])
    println("person is Person17: " + person.isInstanceOf[Person17])
    println("person is Student: " + person.isInstanceOf[Student17])

    val person2: Person17 = new Person17("cary", 35)
    println("person2 is Student17: " + person2.isInstanceOf[Student17])

    // 类型转换
    if (person.isInstanceOf[Student17]){
      val newStudent = person.asInstanceOf[Student17]
      newStudent.study()
    }

    println(classOf[Student17])
  }
}

class Person17(val name: String, val age: Int){
  def sayHi(): Unit = {
    println("hi from person " + name)
  }
}

class Student17(name: String, age: Int) extends Person17(name, age){
  override def sayHi(): Unit = {
    println("hi from student " + name)
  }
  def study(): Unit = {
    println("student study")
  }
}
