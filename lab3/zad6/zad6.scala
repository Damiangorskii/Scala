object Main extends App 
{
    def silnia (n: Int): Int =
    {
        if (n==0)
        {
            return 1
        }
        else
        {
            var wynik = 1 
            for (i <- 1 to n )
            {
                wynik = wynik*i
            }
            return wynik
        }
        
    }

    def dwumian (n: Int , k: Int): Int =
    {
        var wynik2 = (silnia(n)/(silnia(k)*silnia((n-k))))
        return wynik2
    }

    def trojkat (index: Int): Unit =
    {
        var tab = new Array[Int](index+1)
        

        for (i <- 0 to index)
        {
            
            var x = dwumian(index,i)
            print(" " + (x))
        }
    }


    println("Podaj index: ")
    var index = io.StdIn.readInt()
    for (i <- 0 until index)
    {
        trojkat(i)
        print("\n")
    }

}