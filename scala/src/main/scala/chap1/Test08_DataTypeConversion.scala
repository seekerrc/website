package chap1

/**
 * 数据类型转换
 * https://docs.scala-lang.org/zh-cn/tour/unified-types.html
 */
object Test08_DataTypeConversion {
  def main(args: Array[String]): Unit = {

    // 1. 自动类型转换
    //    （1）自动提升原则：有多种类型的数据混合运算时，系统首先自动将所有数据转换成精度大的那种数据类型，然后再进行计算。
    val a1: Byte = 10
    val b1: Long = 2353
    val result1: Long = a1 + b1
    val result11: Int = (a1 + b1.toInt) // 强转

    //    （2）把精度大的数值类型赋值给精度小的数值类型时，就会报错
    val a2: Byte = 10
    val b2: Int = a2
    //    val c2: Byte = b2    // error

    // 2. 强制类型转换
    //    （1）将数据由高精度转换为低精度，就需要使用到强制转换
    val n1: Int = -2.9.toInt
    println("n1: " + n1)

    //    （2）强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级
    val n2: Int = 2.6.toInt + 3.7.toInt
    val n3: Int = (2.6 + 3.7).toInt
    println("n2: " + n2)
    println("n3: " + n3)

    // 3. 数值类型和String类型的转换
    // (1) 数值转String
    val n: Int = 27
    val s: String = n + ""
    println(s)

    // (2) String转数值
    val m: Int = "12".toInt
    val f: Float = "12.3".toFloat
    val f2: Int = "12.3".toDouble.toInt
    println(f2)
  }
}
