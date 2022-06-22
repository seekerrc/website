package chap1

object Test09_TestOperator {
    def main(args: Array[String]): Unit = {
        // 1. 算术运算符
        val result1: Int = 10 / 3
        println(result1)
        val result3: Double = 10.0 / 3
        println("%5.2f".format(result3))
        val result4: Int = 10 % 3
        println(result4)
    
        println("===================")
        // 2. 比较运算符
        val s1: String = "hello"
        val s2: String = new String("hello")
        // compare value
        println(s1 == s2)
        println(s1.equals(s2))
        // compare reference
        println(s1.eq(s2))
    
        println("===================")
        // 3. 逻辑运算符
        def m(n: Int): Int = {
            println("m被调用")
            n
        }
        val n = 1
        // 短路原则
        println((4 > 5) && m(n) > 0)
        
        // 判断一个字符串是否为空
        def isNotEmpty(str: String): Boolean = {
            return str != null && !("".equals(str.trim))
        }
        println(isNotEmpty(null))
    
        println("===================")
        // 4. 赋值运算符
        var i: Int = 12
        i += 1
        println(i)
        // do not support self increment
        //    i++
    
        println("===================")
        // 5. 位运算符
        val a: Byte = 16
        println(a << 2)
        println(a >> 2)
        println(a >>> 2)
        //println(a <<< 2)
    
        println("===================")
        // 6. 运算符的本质也是方法
        val n1: Int = 12
        val n2: Int = 37
        println(n1.+(n2))
        println(n1 + n2 )
        println(1.34.*(25))
        println(1.34 * 25)
    }
}
