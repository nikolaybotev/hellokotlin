import java.lang.Integer.min

fun countSubstrings(s: String): Int {
        val a = Array(2 * s.length + 3) { ' ' }
        a[0] = '@'
        a[1] = '#'
        a[a.size - 1] = '$'
        var t = 2
        for (i in 0 until s.length) {
            a[t++] = s[i]
            a[t++] = '#'
        }

        val z = Array(a.size) { 0 }
        var center = 0
        var right = 0

        for (i in 1 until a.size - 1) {
            if (i < right) {
                z[i] = min(right - i, z[2 * center - i])
            }
            while (a[i + z[i] + 1] == a[i - z[i] - 1]) {
                z[i]++
            }
            if (i + z[i] > right) {
                center = i
                right = i + z[i]
            }
        }

        var ans = 0
        for (i in 0 until a.size) {
            ans += (z[i] + 1) / 2
        }
        return ans
    }

fun main() {
    val s = "abaaba"

    val ret = countSubstrings(s)

    println("$ret")
}
