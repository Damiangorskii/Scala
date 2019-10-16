object Main extends App
{



    def pierwsza(n: Int): Boolean =
    {
        def pierwsza2 (liczba: Int, dzielnik: Int =2): Boolean =
        {
            if (dzielnik == liczba)
            {
                true
            }
            else
            {
                if (liczba%dzielnik == 0)
                {
                    false
                }
                else
                {
                    pierwsza2(liczba, dzielnik+1)
                }
            }
            
        }
        pierwsza2(n)
    }


    println("Podaj liczbe: ")
    var liczba = io.StdIn.readInt()

    println(pierwsza(liczba))

    
}