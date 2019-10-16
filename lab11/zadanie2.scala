import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object Zad2 extends App
{
  case class Wyslij(a: Double, b: Double, c: Double, serwer: ActorRef)

  case class Sprawdz(a: Double, b: Double, c: Double)



  class Klient extends Actor
  {
    override def receive: PartialFunction[Any, Unit] =
    {
      case Wyslij (a,b,c,serwer) =>
        println("Wysyłam dane")
        serwer ! Sprawdz(a,b,c)
      case b: Boolean =>
        {
          if (b) println("da sie")
          else println("nie da")
        }
    }

  }

  class Serwer extends Actor
  {
    override def receive: PartialFunction[Any, Unit] =
    {
      case Wyslij(a,b,c,serwer) =>
        sender ! Sprawdz(a,b,c)
      case Sprawdz(a,b,c) if (a+b > c) => sender  ! true
      case _ => sender ! false

    }


  }

  val system = ActorSystem()
  val Klient = system.actorOf(Props[Klient], "klient")
  val Serwer = system.actorOf(Props[Serwer], "serwer")

  Klient ! Wyslij(2,1,4,Serwer)

}
