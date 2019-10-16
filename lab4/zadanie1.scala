object zadanie1 extends App {


  //zadanie1
  def compose[A,B,C](f: A => B)(g: B => C): A => C =
  {
    x: A => g(f(x))
  }

  def prod[A,B,C,D](f: A => C, g: B => D): (A, B) => (C, D) =
  {
    (x: A, y: B) => (f(x), g(y))
  }

  def lift[A,B,T](op: (T,T) => T)(f: A => T, g: B => T): (A,B) => T =
  {
    (x:A , y:B) => op(f(x), g(y))
  }

  //zadanie2
  type Pred[A] = A => Boolean

  def and[A](p: Pred[A], q: Pred[A]): Pred[A] =
  {
    (x: A) => (p(x) && q(x))
  }
  def or[A](p: Pred[A], q: Pred[A]): Pred[A] =
  {
    (x: A) => (p(x) || q(x))
  }
  def not[A](p: Pred[A]): Pred[A] =
  {
    (x: A) => (!p(x))
  }
  def imp[A](p: Pred[A], q: Pred[A]): Pred[A] =
  {
    (x: A) => (!(p(x) && !q(x)))
  }

  //zadanie3

  type MSet[A] = A => Int

  def dod[A](ms1: MSet[A], ms2: MSet[A]): MSet[A] =
  {
    (a: A) => ms1(a) + ms2(a)
  }

  def -[A](ms1: MSet[A], ms2: MSet[A]): MSet[A] =
  {
    (a: A) =>
      {
        val res = ms1(a) - ms2(a)
        if (res<0) 0 else res
      }
  }

  def &[A](ms1: MSet[A], ms2: MSet[A]): MSet[A] =
  {
    (a: A) => ms1(a) min ms2(a)
  }

  val ms1 = (n: Int) => n match
  {
    case 1 => 2
    case 3 => 1
    case _ => 0
  }
  val ms2 = (n: Int) => n match
  {
    case 1 => 1
    case 2 => 3
    case _ => 0
  }

  val ms3 = (n: Int) => n match
  {
    case _ => 0
  }

  val ms4 = dod[Int](ms1, ms2)
  val ms5 = &[Int](ms1, ms2)
  println("SIEMA")
  println(ms4)
  println(ms5)
  println("ELO")

 /* def plus[A](ms1: MSet[A], ms2: MSet[A]): MSet[A] =
  {
    lift[A,Int](_ + _)(ms1, ms2)
  }

  def minus[A](ms1: MSet[A], ms2: MSet[A]): MSet[A] =
  {
    compose(lift[A,Int](_ - _)(ms1, ms2) ) (0 max _)
  }

  def intersect[A](ms1: MSet[A], ms2: MSet[A]): MSet[A] =
  {
    lift[A,Int](_ min _)(ms1, ms2)
  }
  */



  //zadanie4


  def size[A](a: Seq[A]): Int =
  {
    (a) match
      {

      case (a1 +: a2) => 1+size(a2)
      case _ if(a.isEmpty) => 0
    }

  }

  val s = Seq(1,3,5,7,8,9)
  println(size(s))

  //zadanie5


  def forall[A](a: Seq[A])(pred: (A) => Boolean): Boolean =
  {
    var index = 0
    val sizee = size[A](a)
    def helper[A](a: Seq[A])(pred:A=>Boolean)(index: Int, sizee: Int): Boolean =
    {
      if (index == sizee) return true
      else if (pred(a(index))==false) return false
      else return helper(a)(pred)(index+1, sizee)
    }
    helper(a)(pred)(index, sizee)

  }

  if(forall[Int](Seq(2,4,6,8))((n:Int)=>{n%2==0}))
    {
      println("Jest parzysta")
    }
  else
    {
      println("Nie jest parzysta")
    }

  //zadanie5

  def forall[A](a: Seq[A])(pred: A => Boolean): Boolean = a match {
    case Seq() => true
    case e +: _ if !pred(e) => false
    case _ +: s => forall(s)(pred)
  }



  //zadanie6

  def merge[A](a: Seq[A], b: Seq[A])(leq: (A, A) => Boolean): Seq[A] = {
    @annotation.tailrec
    def helper(a: Seq[A], b: Seq[A], acc: Seq[A]): Seq[A] = {
      (a, b) match {
        case _ if a.isEmpty || b.isEmpty =>
          acc.reverse ++ a ++ b
        case (ahead +: atail, bhead +: _) if leq(ahead, bhead) =>
          helper(atail, b, ahead +: acc)
        case (_, bhead +: btail ) =>
          helper(a, btail, bhead +: acc)
      }
    }
    helper(a, b, Seq())
  }

  println(merge(Seq(1, 3, 5, 7), Seq(2, 4, 6, 8, 10, 12))((m, n) => m < n).mkString("[", ", ", "]"))



}
