package com.djh.excel.ftpFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dujunhua
 * @create: 2021/09/01 11:02
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private Integer age;

    private String filePath;
}
