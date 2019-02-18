fun main() {
    println(mergeSort(listOf(1, 2, 3, 4)))
    println(mergeSort(listOf(3, 4, 1, 2)))
    println(mergeSort(listOf<Int>()))
    println(mergeSort(listOf(3, 2, 1)))
    println(mergeSort(listOf(2, 1)))
}

fun <T: Comparable<T>> mergeSort(s: List<T>): List<T> {
    if (s.size <= 1) return s;
    val c = (s.size - 1) / 2

    return merge(mergeSort(s.subList(0, c + 1)), mergeSort(s.subList(c + 1, s.size)))
}

fun <T: Comparable<T>> merge(l: List<T>, r: List<T>): List<T> {
    var li = 0
    var ri = 0
    val result = ArrayList<T>()
    while (li < l.size || ri < r.size) {
        if (li < l.size && (ri >= r.size || l[li] <= r[ri])) {
            result.add(l[li])
            li += 1
        } else if (ri < r.size && (li >= l.size || r[ri] < l[li])) {
            result.add(r[ri])
            ri += 1
        }
    }
    return result
}