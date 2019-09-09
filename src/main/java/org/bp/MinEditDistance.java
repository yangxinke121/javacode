package org.bp;

public class MinEditDistance {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();

    private int n = 6;
    private int m = 6;
    private int minDist = Integer.MAX_VALUE;

    public int lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) {
                edist += (n - i);
            }
            if (j < m) {
                edist += (m - j);
            }
            if (edist < minDist) {
                minDist = edist;
            }
            return minDist;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1, j + 1, edist);
        } else {
            lwstBT(i + 1, j, edist + 1);
            lwstBT(i, j + 1, edist + 1);
            lwstBT(i + 1, j + 1, edist + 1);
        }
        return minDist;
    }

    public static void main(String[] args) {

        MinEditDistance min = new MinEditDistance();
        System.out.println(min.lwstBT(0, 0, 0));
        System.out.println(min.minDist);
    }
}
