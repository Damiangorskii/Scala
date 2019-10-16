object Main 
{
    def isPrime(x: Int) : Boolean = 
    {
        var n = 2
        while (n<=x/2)
        {
            if (x%n==0)
            {
                return false
            }
            n+=1
        }
        true
    }


    def main(args: Array[String]) 
    {
        println("Podaj parzysta liczbe wieksza od 2")
        var number = io.StdIn.readInt()
        var a = 3
        var b = number - 3

        
        if (number <=2)
        {
            println("Podales zla liczbe")
            
        }
        else
        {
            while (!(isPrime(a) && isPrime(b)))
            {
                a=a+2
                b=b-2
            }
            println(a)
            println(b)
        }

        if (isPrime(9))
        {
            println("Dziewioatka jest pierwsza")
        }
        else
        {
            println("Nie jest pierwsza!")
        }

        
        

    }


}

