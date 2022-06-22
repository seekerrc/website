package chap5

import scala.collection.immutable.Queue
import scala.collection.mutable

/**
 * mutable.Queue 队列
 */
object Test19_Queue {
  def main(args: Array[String]): Unit = {
    // 创建一个可变队列
    val queue: mutable.Queue[String] = new mutable.Queue[String]()

    queue.enqueue("a", "b", "c")
    println(queue)
    println(queue.dequeue())
    println(queue)
    println(queue.dequeue())
    println(queue)

    queue.enqueue("d", "e")
    println(queue)
    println(queue.dequeue())
    println(queue)

    println("==========================")
    // 不可变队列，每次改变需要用一个新变量存储结果
    val queue2: Queue[String] = Queue("a", "b", "c")
    val queue3 = queue2.enqueue("d")
    println(queue2)
    println(queue3)
  }
}
