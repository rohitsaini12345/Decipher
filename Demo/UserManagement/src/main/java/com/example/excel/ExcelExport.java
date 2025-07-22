package com.example.excel;

import com.example.entity.User;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExcelExport {

    private List<User> userList;

    public ExcelExport(List<User> userList) {
        this.userList = userList;
    }

    public void export(HttpServletResponse response) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Users");

        writeHeader(sheet);
        writeData(sheet);

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private void writeHeader(XSSFSheet sheet) {
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("Role");
    }

    private void writeData(XSSFSheet sheet) {
        int rowCount = 1;
        for (User user : userList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getEmail());
            row.createCell(3).setCellValue(user.getRole());
        }
    }
}

