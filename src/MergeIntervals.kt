fun main() {
    println(merge(listOf(I(0, 1)), listOf(I(1, 2))))
    println(merge(listOf(I(0, 1)), listOf(I(2, 3))))
    println(merge(listOf(I(0, 7)), listOf(I(1, 2), I(3, 4), I(5, 8))))
    println(merge(listOf(), listOf(I(1, 2), I(3, 4), I(5, 8))))
    println(merge(listOf(I(1, 2), I(3, 4), I(5, 8)), listOf()))
    println(merge(listOf(), listOf()))
}

data class I(val l: Int, val r: Int) {
    fun overlaps(other: I): Boolean {
        return this.l <= other.r && other.l <= this.r
    }
    fun merge(other: I): I {
        return I(Math.min(this.l, other.l), Math.max(this.r, other.r))
    }
}


fun merge(a: List<I>, b: List<I>): List<I> {
    val result = ArrayList<I>()

    var ai = 0
    var bi = 0
    while (ai < a.size || bi < b.size) {
        if (ai < a.size && (bi >= b.size || a[ai].l <= b[bi].l)) {
            mergeOne(result, a[ai])
            ai += 1
        } else if (bi < b.size && (ai >= a.size || b[bi].l < a[ai].l)) {
            mergeOne(result, b[bi])
            bi += 1
        }
    }

    return result
}

fun mergeOne(r: MutableList<I>, i: I) {
    if (r.isEmpty()) {
        r.add(i)
    } else {
        val l = r.last()
        if (i.overlaps(l)) {
            r[r.lastIndex] = l.merge(i)
        } else {
            r.add(i)
        }
    }
}
