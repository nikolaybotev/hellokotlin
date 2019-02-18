import java.lang.IllegalStateException

fun main() {
    println(flatten(listOf(listOf("a"))))
    println(flatten(listOf(listOf("a", "b"))))
    println(flatten(listOf(listOf("a"), listOf(), listOf())))
    println(flatten(listOf(listOf("a"), listOf(), listOf("b", "c"))))
    println(flatten(listOf(listOf(), listOf(), listOf("b", "c"))))
    println(flatten(listOf(listOf<Int>(), listOf(), listOf())))
    println(flatten(listOf<Iterable<Int>>()))
    println("Done")
}

class FlatIterator<T, V: Iterable<T>>(c: Iterable<V>) : Iterator<T> {
    private val upper = c.iterator()
    private var lower: Iterator<T> = listOf<T>().iterator()

    override fun hasNext(): Boolean {
        while (!lower.hasNext() && upper.hasNext()) {
            lower = upper.next().iterator()
        }
        return lower.hasNext()
    }

    override fun next(): T {
        if (!hasNext()) {
            throw IllegalStateException()
        }
        return lower.next()
    }

}

fun <T, V: Iterable<T>> flatten(it: Iterable<V>): List<T> {
    return FlatIterator(it).asSequence().toList()
}