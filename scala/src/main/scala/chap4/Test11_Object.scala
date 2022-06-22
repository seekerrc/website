package chap4

/**
 * 伴生对象，作为static的方法属性集合
 * 当一个单例对象和某个类共享一个名称时，这个单例对象称为 伴生对象。
 * 同理，这个类被称为是这个单例对象的伴生类。类和它的伴生对象可以互相访问其私有成员。
 * 使用伴生对象来定义那些在伴生类中不依赖于实例化对象而存在的成员变量或者方法。
 */
object Test11_Object {
  def main(args: Array[String]): Unit = {
//    val student = new Student11("alice", 18)
//    student.printInfo()

    val student1 = Student11.newStudent("alice", 18)
    student1.printInfo()

    val student2 = Student11.apply("bob", 19)
    student2.printInfo()
    // apply可以省略：
    val student3 = Student11("bob", 19)
    student3.printInfo()
  }
}

// 定义类，private构造器私有化
class Student11 private(val name: String, val age: Int){
  def printInfo(){
    println(s"student: name = ${name}, age = $age, school = ${Student11.school}")
  }
}

// 伴生对象，可以理解为静态属性和方法的集合
object Student11{
  val school: String = "atguigu"

  // 定义一个类的对象实例的创建方法
  def newStudent(name: String, age: Int): Student11 = new Student11(name, age)

  // 规范写法，魔法方法
  def apply(name: String, age: Int): Student11 = new Student11(name, age)
}