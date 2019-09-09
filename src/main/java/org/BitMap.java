package org;

import java.io.*;

public class BitMap {

    private int[] bitMap;

    public BitMap(int length) {
        bitMap = new int[(length >> 5) + (length & 31) > 0 ? 1 : 0];
    }

    private void setBit(int index) {
        int belowIndex = (index - 1) >> 5;
        int offset = (index - 1) & 31;
        int data = bitMap[belowIndex];
        bitMap[belowIndex] = data | 0x01 << offset;
    }

    private int getBit(int index) {
        int data = bitMap[(index - 1) >> 5];
        int offset = (index - 1) & 31;
        return data >> offset & 0x01;
    }

    public static void writeLog(String file, String content) {

        BufferedWriter out = null;
        try {
            File file1 = new File(file);
            if (!file1.exists()) {
                file1.getParentFile().mkdirs();
            }
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file1, true)));
            out.write(content + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // BitMap bitMap = new BitMap(32);
        // bitMap.setBit(32);
        // bitMap.setBit(5);
        // bitMap.setBit(123131);
        // System.out.println(bitMap.getBit(1));
        // System.out.println(bitMap.getBit(12));
        // System.out.println(bitMap.getBit(32));
    }
}
