object cwiczenia10 extends App{

  import scala.io.Source


  //Zadanie 2

  val names: Seq[String] = Source.fromFile("src\\osoby.txt").getLines.toList
  val mappedNames =  names.groupBy((s: String) => s.length - 1)
  println("Zadanie2")
  println(mappedNames)
  println("\n")

  //Zadanie 3

  val numbers: Seq[Int] = Source.fromFile("src\\liczby.txt").getLines.toList.
    map((s: String) => s.toInt)
  val result = (numbers.filter((n: Int) => n%2==0), numbers.filter((n: Int) => n%2 != 0))
  println("Zadanie3")
  println(result)
  println("\n")


  //Zadanie 4

  val instances: Int = Source.fromFile("src\\cyfry.txt").getLines.toList.map((s: String) => s.toList.map((c: Char) => (c + "").toInt)).foldLeft(0)((i: Int, seq: Seq[Int]) => i + f(seq)())

  def f(seq: Seq[Int], j: Int = 0)(isSeq: Boolean = false): Int = seq match {
    case Seq() => j
    case e1 +: e2 +: s if e1 < e2 && isSeq => f(e2 +: s, j)(isSeq = true)
    case e1 +: e2 +: s if e1 < e2 => f(e2 +: s, j+1)(isSeq = true)
    case _ +: s if isSeq => f(s, j)(isSeq = false)
    case _ +: s => f(s, j)()
  }




}
