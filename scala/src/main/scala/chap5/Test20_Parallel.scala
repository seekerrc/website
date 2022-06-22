package chap5

import scala.collection.immutable
import scala.collection.parallel.immutable.ParSeq

/**
 * 集合的并行处理，用另外一组集合类
 */
object Test20_Parallel {
  def main(args: Array[String]): Unit = {
    val result: immutable.IndexedSeq[Long] = (1 to 100).map(
      x => Thread.currentThread.getId
    )
    println(result)

    val result2: ParSeq[Long] = (1 to 100).par.map(
      x => Thread.currentThread.getId
    )
    println(result2)
  }
}
