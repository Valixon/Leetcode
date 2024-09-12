object L_1980 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(findDifferentBinaryString(arrayOf("01", "10")))
        println(findDifferentBinaryString(arrayOf("00", "01")))
        println(findDifferentBinaryString(arrayOf("111", "011", "001")))
    }

    fun findDifferentBinaryString(nums: Array<String>): String {
        val sb = StringBuilder()
        for (i in nums.indices) {
            sb.append(if (nums[i][i] == '0') "1" else "0")
        }
        return String(sb)
    }
}