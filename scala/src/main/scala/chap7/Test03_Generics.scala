package chap7

/**
 *  Scala支持 泛型类 的类型参数的型变注释，允许它们是协变的，逆变的，或在没有使用注释的情况下是不变的。
 *  在类型系统中使用型变允许我们在复杂类型之间建立直观的连接
 *
 *  使用注释 +A，可以使一个泛型类的类型参数 A 成为协变。
 *  对于某些类 class List[+A]，使 A 成为协变意味着
 *  对于两种类型 A 和 B，如果 A 是 B 的子类型，那么 List[A] 就是 List[B] 的子类型。
 *  这允许我们使用泛型来创建非常有用和直观的子类型关系。
 *
 *  通过使用注释 -A，可以使一个泛型类的类型参数 A 成为逆变。 但其作用与协变完全相反。
 *  对于某个类 class Writer[-A] ，使 A 逆变意味着对于两种类型 A 和 B，如果 A 是 B 的子类型
 *  那么 Writer[B] 是 Writer[A] 的子类型。
 *
 *  https://docs.scala-lang.org/zh-cn/tour/variances.html
 *
 *  类型参数和抽象类型都可以有一个类型边界约束。
 *  比如 `T <: A` 这样声明的类型上界表示类型变量T应该是类型A的子类。
 */
object Test03_Generics {
  def main(args: Array[String]): Unit = {
    // 1. 协变和逆变
    val child: Parent = new Child
//    val childList: MyCollection[Parent] = new MyCollection[Child]
    val childList: MyCollection[SubChild] = new MyCollection[Child]

    // 2. 上下限
    def test[A <: Child](a: A): Unit = {
      println(a.getClass.getName)
    }
    test[SubChild](new SubChild)
    test[Child](new Child)
  }
}

// 定义继承关系
class Parent {}
class Child extends Parent {}
class SubChild extends Child {}

// 定义带泛型的集合类型
class MyCollection[-E] {}