package basething.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;
        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String src = "allmypro/resources/src.txt";
        String dist = "allmypro/resources/dist.txt";
        copyFile(src, dist);
    }
}
