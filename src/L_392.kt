import java.util.*

object L_392 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        println(isSubsequence(sc.next(), sc.next()))
    }

    fun isSubsequence(s: String, t: String): Boolean {
        var t = t
        if (s.length > t.length) {
            return false
        }
        if (s == t) {
            return true
        }
        var index0 = 0
        var x: Char
        var q: Int
        while (index0 < s.length) {
            x = s[index0]
            q = t.indexOf(x)
            if (q == -1) {
                return false
            }
            t = t.substring(q + 1)
            index0++
        }
        return true
    }
}