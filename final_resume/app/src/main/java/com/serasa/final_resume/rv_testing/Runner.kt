package com.serasa.final_resume.rv_testing

fun main() {
    println(runOperation(2,4,OperationType.SUM))

    println(runOperation(2,4,::sum))

    println(runOperation(2,4,OperationType.MULTIPLY))

    println(runOperation(2,4,::multiply))

    RVAdapter(::test)

}

fun runOperation(num1: Int, num2: Int, type: OperationType): Int {
    return if (type == OperationType.MULTIPLY) multiply(num1, num2) else sum(num1, num2)
}

fun runOperation(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun sum(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun multiply(num1: Int, num2: Int): Int {
    return num1 * num2
}

fun test(parameter: String){

}

enum class OperationType {
    SUM,
    MULTIPLY
}