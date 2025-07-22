package com.example.excel;

import com.example.entity.User;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelImport {

    public static List<User> parseExcelFile(InputStream inputStream) throws IOException {
        List<User> userList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            User user = new User();
            user.setName(row.getCell(1).getStringCellValue());
            user.setEmail(row.getCell(2).getStringCellValue());
            user.setRole(row.getCell(3).getStringCellValue());

            userList.add(user);
        }

        workbook.close();
        return userList;
    }

}

