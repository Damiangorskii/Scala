object Main extends App
{

    def ciag(n: Int): Int =
    {
        def ciag2(liczba: Int, a: Int=1, b:Int=1): Int =
        {
            if (liczba == 0)
            {
                b
            }
            else
            {
                ciag2(liczba-1, a+b, a)
            }
        }
        ciag2(n)
    }

    println("Podaj liczbe: ")
    var liczba = io.StdIn.readInt()

    println(ciag(liczba))
}