package com.djh.demo.Demo.IO;

import java.io.*;

/**
 * 递归操复制本地文件夹中图片
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Demo.copyFileByTaskId("F:\\MyFolder\\tp");
    }

    public static boolean copyFileByTaskId(String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                return true;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        Demo.copyFileByTaskId(file2.getAbsolutePath());
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        FileInputStream inputStream = new FileInputStream(absolutePath);
                        String name = file2.getName();
                        int indexOf = absolutePath.lastIndexOf(name);
                        String substring = absolutePath.substring(0, indexOf);
                        if (name.contains("12345")) {
                                name = name.replace("123", "bbb");
                            String st = "aaa" + name;
                            FileOutputStream outputStream = new FileOutputStream(substring + name);
                            try {
                                byte[] bytes = new byte[1024];
                                int read = 0;
                                while ((read = inputStream.read(bytes)) > 1) {
                                    outputStream.write(bytes);
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    outputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
