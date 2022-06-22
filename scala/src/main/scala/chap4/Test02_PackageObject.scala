/**
 * 包对象，全包共享
 */
package chap4{
  object Test02_PackageObject {
    def main(args: Array[String]): Unit = {
      commonMethod()
      println(commonValue)
    }
  }
}

package ccc{
  package ddd{
    object Test02_PackageObject{
      def main(args: Array[String]): Unit = {
        println(school)
      }
    }
  }
}

// 定义一个包对象
package object ccc{
  val school: String = "atguigu"
}