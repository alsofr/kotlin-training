package com.freiheit.trainings.kotlin.syntax

sealed class MyType {
    object A : MyType()
    data class B(val someValue: Any) : MyType() {
        fun getTypeDescription() = "the type is B!"
    }
    sealed class C: MyType() {
        object C1: C()
        object C2: C()
    }

}
class D(val someValue: Any) : MyType()


// Exhaustive `when`
private fun someFunction(value: MyType): String {
    return when (value) {
        MyType.A -> "the type is A!"    // match by reference
        is MyType.B -> {                // match by type
            value.getTypeDescription()  // smart-cast
        }
        MyType.C.C1 -> "the type is C1!"
        MyType.C.C2 -> "the type is C2!"
        is D -> TODO()
    }
}


// Casts and checks
private fun cast(value: MyType): Boolean {
    (value as? MyType.B)?.getTypeDescription()

    (value as MyType.B).getTypeDescription()

    return value is MyType.C
}