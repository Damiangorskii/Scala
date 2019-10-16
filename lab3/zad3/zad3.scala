object Main extends App
{
    def policz(str: String): Int =
    {
        def policz2(slowo: String, licznik: Int = 0): Int =
        {
            if (slowo.length==0) licznik
            else 
            if (slowo.charAt(0)<=122 && slowo.charAt(0)>=97)
            {
                
                policz2(slowo.substring(1), licznik+1)
            }
            else
            {
                policz2(slowo.substring(1), licznik)
            }
        }
        policz2(str)
    }


    println("Podaj slowo")
    var slowo = io.StdIn.readLine()

    println(policz(slowo))
}