public class L_1863 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    public static int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot = nums[i];
            sum += tot;
            for (int j = i + 1; j < n; j++) {
                tot = nums[i] ^ nums[j];
                sum += tot;

                for (int k = j + 1; k < n; k++) {
                    tot = nums[i] ^ nums[j] ^ nums[k];
                    sum += tot;

                    for (int l = k + 1; l < n; l++) {
                        tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l];
                        sum += tot;
                        for (int m = l + 1; m < n; m++) {
                            tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m];
                            sum += tot;
                            for (int o = m + 1; o < n; o++) {
                                tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o];
                                sum += tot;
                                for (int p = o + 1; p < n; p++) {
                                    tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o] ^ nums[p];
                                    sum += tot;
                                    for (int q = p + 1; q < n; q++) {
                                        tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o] ^ nums[p] ^ nums[q];
                                        sum += tot;
                                        for (int r = q + 1; r < n; r++) {
                                            tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o] ^ nums[p] ^ nums[q] ^ nums[r];
                                            sum += tot;
                                            for (int s = r + 1; s < n; s++) {
                                                tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o] ^ nums[p] ^ nums[q] ^ nums[r] ^ nums[s];
                                                sum += tot;
                                                for (int t = s + 1; t < n; t++) {
                                                    tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o] ^ nums[p] ^ nums[q] ^ nums[r] ^ nums[s] ^ nums[t];
                                                    sum += tot;
                                                    for (int u = t + 1; u < n; u++) {
                                                        tot = nums[i] ^ nums[j] ^ nums[k] ^ nums[l] ^ nums[m] ^ nums[o] ^ nums[p] ^ nums[q] ^ nums[r] ^ nums[s] ^ nums[t] ^ nums[u];
                                                        sum += tot;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return sum;
    }
}