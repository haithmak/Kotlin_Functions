import kotlin.random.Random

/*
let can be used to invoke one or more functions on results of call chains.
 */



data class Person(var name: String, var age: Int = 0, var city: String = "")



class MultiportService(var url: String, var port: Int) {
    fun prepareRequest(): String = "Default request"
    fun query(request: String): String = "Result for query '$request'"
}


fun main(args: Array<String>) {


    /*1-apply: can be thought of as a configuration function: It allows you to
    call a series of functions on a
    receiver to configure it for us
    */
    val adam = Person("Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)

    /*2-with :A non-extension function: the context object is passed as an argument,
    but inside the lambda, it's available as a receiver (this). The return value is
    the lambda result.
    */

    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }

    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)


    /*3-run : does the same as with but invokes as let - as an extension
     function of the context object.
    run is useful when your lambda contains both the object initialization
    and the computation of the return
     */

    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    // the same code written with let() function:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }
    println(result)
    println(letResult)

    //4-let: scopes a variable to the lambda provided and makes the Keyword it
    val firstElement = listOf(1,2,3).first()
    val firstItemSquared = firstElement * firstElement
    println(firstItemSquared)

    val firstItemSquaredlet = listOf(1,2,3).first().let {
        it * it
    }
    println(firstItemSquaredlet)

   
    /*5-also: is good for performing some actions that take the context object as an argument.
     Use also for actions that need a reference rather to the object than to its properties
      and functions, or when you don't want to shadow this reference from an outer scope.
     */
    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")
    println(numbers)



    /*6-takeIf : returns this object if it matches the predicate. Otherwise,
     it returns null. So, takeIf is a filtering function for a single object
     */
    val number = Random.nextInt(100)
    println("Number: $number")
    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeIf { it % 2 != 0 }
    println("even: $evenOrNull, odd: $oddOrNull")
}