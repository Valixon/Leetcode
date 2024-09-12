import java.util.*

object L_1846 {
    @JvmStatic
    fun main(args: Array<String>) {
        print(maximumElementAfterDecrementingAndRearranging(intArrayOf(2, 2, 1, 2, 1)))
        print(maximumElementAfterDecrementingAndRearranging(intArrayOf(100, 1, 1000)))
        print(maximumElementAfterDecrementingAndRearranging(intArrayOf(1, 2, 3, 4, 5)))
        print(maximumElementAfterDecrementingAndRearranging(intArrayOf(1, 1, 3, 3, 3, 3, 6)))
        print(maximumElementAfterDecrementingAndRearranging(intArrayOf(73, 98, 9)))
    }

    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        val l = arr.size
        for (i in 0 until l) {
            if (arr[i] > l) {
                arr[i] = l
            }
        }
        Arrays.sort(arr)
        var x = 0
        for (i in arr) {
            if (i > x) {
                x++
            }
        }
        return x
    }
}