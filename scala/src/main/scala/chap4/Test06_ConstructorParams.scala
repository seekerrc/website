package chap4

/**
 * 构造器传参
 */
object Test06_ConstructorParams {
  def main(args: Array[String]): Unit = {
    val student2 = new Student2
    student2.name = "alice"
    student2.age = 18
    println(s"student2: name = ${student2.name}, age = ${student2.age}")

    val student3 = new Student3("bob", 20)
    println(s"student3: name = ${student3.name}, age = ${student3.age}")

    val student4 = new Student4("cary", 25)
    //println(s"student4: name = ${student4.name}, age = ${student4.age}")
    student4.printInfo()

    val student5 = new Student5("bob", 20)
    println(s"student3: name = ${student5.name}, age = ${student5.age}")

  }
}

// 定义类
// 无参构造器
class Student2 {
  // 单独定义属性
  var name: String = _
  var age: Int = _
}

// 上面定义等价于
class Student3(var name: String, var age: Int)

// 主构造器参数无修饰，不会存储为成员变量，点击左侧structure面板可以验证这一点
class Student4(name: String, age: Int){
  def printInfo(){
    println(s"student4: name = ${name}, age = $age")
  }
}

//class Student4(_name: String, _age: Int){
//  var name: String = _name
//  var age: Int = _age
//  def printInfo(){
//    println(s"student4: name = ${name}, age = $age")
//  }
//}

class Student5(val name: String, val age: Int)
