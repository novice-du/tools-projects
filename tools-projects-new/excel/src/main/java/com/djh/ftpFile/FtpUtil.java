package com.djh.ftpFile;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.SocketException;

/**
 * @author: dujunhua
 * @create: 2021/08/31 15:41
 * @description:
 */
@Component
public class FtpUtil {

    @Autowired
    UserMapper autoBaseMapper;

    private static FtpUtil ftpUtil;
    private static UserMapper userMapper;

    /**
     * 如果需要持久化数据，注入静态dao
     */
    @PostConstruct
    public void init() {
        userMapper = autoBaseMapper;
        ftpUtil = this;
    }

    /**
     * HOST_NAME:主机
     * PORT:端口
     * USER_NAME:用户名
     * PASSWORD:密码
     */
    private static final String HOST_NAME = "172.20.10.6";
    private static final Integer PORT = 21;
    private static final String USER_NAME = "rxnb";
    private static final String PASSWORD = "RongXin";

    /**
     * 外网
     */
    public static void main(String[] args) throws Exception {
        FTPClient ftpClient = FtpUtil.connectFtp(HOST_NAME, PORT, USER_NAME, PASSWORD);
        FTPFile[] ftpFiles = ftpClient.listFiles();
        for (FTPFile ftpFile : ftpFiles) {
            //获取文件名
            String fileName = ftpFile.getName();
            //后缀名
            String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            //ftp设置的是utc时间,和系统时间有8小时时差,所以需要加上时差
//            Long lastModifiedTime = ftpFile.getTimestamp().getTimeInMillis() + ftpFile.getTimestamp().getTimeZone().getOffset(0);
            System.out.println("读取到文件：" + fileName);
            //根据文件后缀判断是哪个文件
            switch (suffix) {
                case ".txt":
                    InputStream is = ftpClient.retrieveFileStream(ftpFile.getName());
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String content = "";
                    //一次读入一行数据
                    while ((content = br.readLine()) != null) {
                        System.out.println("content = " + content);
                    }
                    br.close();
                    is.close();
                    //结束事务(有流返回时需手动调用,否则会报输入流为空)
                    ftpClient.completePendingCommand();
                    break;
                case ".jpg":
                    //转换文件类型
                    FileInputStream fileInputStream = new FileInputStream("D:\\ftp\\LocalUser\\rxnb\\" + fileName);
                    MultipartFile multipartFile = new MockMultipartFile(fileName, fileName,
                            ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
                    insertRar(multipartFile, fileName);
                    break;
            }

        }
    }

    /**
     * 连接FTP
     *
     * @param hostname 服务器地址
     * @param port     端口号(默认为21)
     * @param username 帐号
     * @param password 密码
     */
    public static FTPClient connectFtp(String hostname, int port, String username, String password) {
        FTPClient ftp = new FTPClient();
        try {
            //连接FTP服务器
            ftp.connect(hostname, port);
            boolean login = ftp.login(username, password);
            if (login) {
                System.out.println(">>>>>>>>FTP-->登录成功>>>>>>>>>>>>>");
            } else {
                System.out.println(">>>>>>>>FTP-->登录失败>>>>>>>>>>>>>");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     * 保存图片
     *
     * @param file
     * @param filename
     */
    public static void insertRar(MultipartFile file, String filename) {
        String dirPath = "D:/photo/";
        try {
            // 文件路径
            String filePath = new StringBuilder(dirPath).append(filename).toString();
            // 保存文件
            System.out.println("uploadInsert filePath: " + filePath);
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("请求错误");
        }
    }

}
