/*

1-Explicit type
Occasionally Kotlin can't infer our types and we must explicitly declare the type for
our lambda; just as we can with any other type.
The pattern is input -> output, however, if the code returns no value we use the type Unit:


2-Type Inference
Kotlin's type inference allows the type of a lambda to be evaluated by the compiler.
Writing a lambda that produces the square of a number would be as written as:
 */


fun main(args: Array<String>) {

    //0-anonymous functions types
    val anonymous1 = fun(x: Int, y: Int): Int = x + y
    //invoking funtions
    var sum1 = anonymous1(3,5)
    println(sum1) ;


    //1-Explicit type
    val lambda1: (Int) -> Int = {a-> a * a}
    val sq =lambda1(2)
    println(sq) ;

    val lambda2: (String,String) -> String = { a , b -> a + b }
    val str =lambda2("2","3")
    println(str) ;

    val lambda3: (Int)-> Unit = {print(Int)}
    val n  =lambda3(2)
    println(n) ;

    val lambda4: String.(Int) -> String = {this + it}
    val result = "Number: ".lambda4(50)
    print(result)

    //2-Type Inference
    val sum = {a: Int , b: Int -> a + b}
    println(sum(1,4))

    val square = { number: Int -> (number * number).toString() }
    val nine = square(3)
    println(nine)



}