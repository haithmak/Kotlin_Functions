/*
infix notation means calling without using parenthesis and dot.

There are two types of infix function notation in Kotlin-
1-Standard library infix function notation
2-User defined infix function notation

 infix functions must satisfy the following requirements:

They must be member functions or extension functions;
They must have a single parameter;
The parameter must not accept variable number of arguments and must have no default value.
*/

class math {
    infix fun square(n: Int): Int {
        val num = n * n
        return num
    }
}


  fun main(args: Array<String>) {
      //Standard library infix function
        var a = 8
        var b = 4

        println(++a)      // call using infix notation
        println(a.inc())  // call using dot and parenthesis
        println(--b)      // call using infix notation
        println(b.dec())  // call using dot and parenthesis


       a = 15
       b = 12
      var c = 11
      // call using dot and parenthesis
      var result1 =(a > b).and(a > c)
      println("Boolean result1 = $result1")
      // call using infix notation
      var result2 =(a > b) and (a > c)
      println("Boolean result1 = $result2")




      // user defined infix member function
      val m = math()
      // call using infix notation
      val result = m square 3
      print("The square of a number is: "+result)


  }
// user defined infix member function
