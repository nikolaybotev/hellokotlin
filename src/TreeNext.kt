fun main() {
    val t1 = TN(1)
    val t3 = TN(3)
    val t4 = TN(4, t3, null)
    val t2 = TN(2, t1, t4)
    val t6 = TN(6)
    val t8 = TN(8)
    val t7 = TN(7, t6, t8)
    val t5 = TN(5, t2, t7)
    println(next(t1))
    println(next(t2))
    println(next(t3))
    println(next(t4))
    println(next(t5))
    println(next(t6))
    println(next(t7))
    println(next(t8))
}

data class TN(val value: Int, val l: TN?, val r: TN?) {
    var p: TN? = null
        private set

    init {
        l?.p = this
        r?.p = this
    }

    constructor(value: Int) : this(value, null, null)
}

fun next(node: TN): TN? {
    if (node.r != null) {
        var c = node.r
        while (c?.l != null) {
            c = c.l
        }
        return c
    }
    var p = node.p
    while (p != null && p.value < node.value) {
        p = p.p
    }
    return p
}