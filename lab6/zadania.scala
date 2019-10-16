object zadania extends App
{
  //Zadanie1

  def applyForAll(seq: Seq[String], f: String => Int): Seq[Int] =
  {
    seq match {
      case Seq() => Seq()
      case pierwszy +: reszta => f(pierwszy) +: applyForAll(reszta, f)

    }

  }

  val s1 = Seq("ala", "ma", "kota")
  val fun = (str: String) => 2 * str.length
  def fun2(str: String): Int = str.length * 3
  println(applyForAll(s1, (str: String) => {str.length}))
  println(applyForAll(s1, (str: String) => str(0).toInt))
  println(applyForAll(s1, fun))
  println(applyForAll(s1, fun2))

  def applyForAllGEN[A,B](seq: Seq[A], f: A => B): Seq[B] =
  {
    seq match {
      case Seq() => Seq()
      case pierwszy +: reszta => f(pierwszy) +: applyForAllGEN(reszta, f)

    }

  }
  println(applyForAllGEN(Seq(1,2,3,4), (n: Int) => "#" * n))

  def applyForAllOgonowa[A,B](seq: Seq[A], f: A => B): Seq[B] = {

    def helper(inp: Seq[A], out: Seq[B]): Seq[B] ={
      inp match {
        case Seq() => out.reverse
        case pierwszy +: reszta => helper(reszta, f(pierwszy) +: out)
      }
    }
    helper(seq, Seq())
  }

  //Zadanie2

  def applyForAll2[A, B, C](seq1: Seq[A], seq2: Seq[B], f: (A, B) => C): Seq[C] =
  {
    def helper(inp: Seq[A], inp2: Seq[B], out: Seq[C]): Seq[C]=
    {
      (inp, inp2) match{
        case (pierwszy +: reszta, pierwszy2 +: reszta2) => helper(reszta, reszta2,f(pierwszy,pierwszy2) +: out)
        case (_) => out.reverse
      }
    }
    helper (seq1, seq2, Seq())
  }

  val seq1 = Seq(2,3,4,5)
  val seq2 = Seq(2,3,4,6,8)

  println(applyForAll2(seq1, seq2, (a: Int, b: Int) => a*b))


  //Zadanie3


  def divide[A](seq: Seq[A]): (Seq[A], Seq[A]) =
  {
    def helper (seq: Seq[A], out: ( Seq[A], Seq[A])): (Seq[A], Seq[A])=
    {
      seq match
        {
        case Seq() => (out._1.reverse, out._2.reverse)
        case (pierwszy +: drugi +: reszta) => helper(reszta, (pierwszy +: out._1, drugi +: out._2))
        case Seq(pierwszy) => ((pierwszy +: out._1).reverse, out._2.reverse)
      }
    }
    helper (seq, (Seq(), Seq()))
  }

  val seq11 = Seq(1,2,3,4,5,6)
  val seq22 = Seq(8,9,10)

  println(divide(seq11))
  println(divide(seq22))

  //Zadanie4


  def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B =
  {
    def helper (inp: Seq[A], acc: B ): B =
    {
       inp match
        {
        case Seq() => acc
        case pierwszy +: reszta => helper(reszta, op(pierwszy, acc))

      }
    }
    helper (seq, init)
  }

  println(compute(Seq(1,2,3,4,5,6))(init = 0){(m: Int, n: Int) => m+n})
  println(compute(Seq(1,2,3,4,5,6))(Seq[String]()){(m: Int, acc: Seq[String]) => "#" * m +: acc})
  println(compute(Seq(1,2,3,4,5,6))(0,Seq[String]()){(m: Int, acc: (Int, Seq[String])) => (m+acc._1,"#" * m +: acc._2)})

  //Zadanie5

  def size[A](a: Seq[A]): Int =
  {
    compute(a)(0)((_,n: Int)=> n+1)
  }

  val seq111 = Seq(1,2,3,4,5,6,7,8)
  println(size(seq111))


  def reverse[A](a: Seq[A]): Seq[A] =
  {
    compute(a)(Seq(): Seq[A])((e: A, out: Seq[A]) => e +: out)
  }
  println(reverse(seq111))

  def applyforall[A, B](a: Seq[A], f: A => B): Seq[B] =
  {
    compute(a)(Seq(): Seq[B])((a: A, out: Seq[B]) => f(a) +: out).reverse
  }

  println(applyforall(seq111, (a: Int) => a+1))

  def filter[A](a: Seq[A], pred: A=>Boolean): Seq[A] =
  {
    compute(a)(Seq(): Seq[A])((a: A, out: Seq[A]) => if(pred(a)) a +: out else out).reverse
  }

  println(filter(seq111, (a: Int) => a>5))

  def forall[A](a: Seq[A], pred: A=>Boolean): Boolean =
  {
    compute(a)(true)((a: A, out: Boolean) => if (pred(a)) out else false)
  }

  println(forall(seq111, (a: Int) => a>0))



}
