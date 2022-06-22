package chap4

/**
 * 自类型，类似组合(将一个trait或者class的东西声明为自己的)
 * 用于声明一个特质必须混入其他特质，尽管该特质没有直接扩展其他特质
 * 这使得所依赖的成员可以在没有导入的情况下使用
 * someIdentifier: SomeOtherTrait =>
 * https://docs.scala-lang.org/zh-cn/tour/self-types.html
 */
object Test16_TraitSelfType {
  def main(args: Array[String]): Unit = {
    val user = new RegisterUser("alice", "123456")
    user.insert()
  }
}

// 用户类
class User(val name: String, val password: String)

trait UserDao {
  _: User =>

  // 向数据库插入数据
  def insert(): Unit = {
    println(s"insert into db: ${this.name}")
  }
}

// 定义注册用户类
class RegisterUser(name: String, password: String) extends User(name, password) with UserDao