package com.azold6.rodartenogueirabackend.utils;

import com.azold6.rodartenogueirabackend.models.Aluno;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "dados.xlsx";

    public static List<Aluno> lerExcel() {
        List<Aluno> alunos = new ArrayList<>();
        boolean isFirstRow = true;

        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                if(isFirstRow){
                    isFirstRow = false;
                    continue;
                }

                int iteracao = 0;
                Aluno tempAluno = new Aluno();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    switch (iteracao){
                        case 0:
                            tempAluno.setIdentificacao((int) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            tempAluno.setNome(currentCell.getStringCellValue());
                            break;
                        case 2:
                            tempAluno.setSexo(currentCell.getStringCellValue());
                            break;
                        case 3:
                            tempAluno.setDataDeNascimento(currentCell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                            break;
                        case 4:
                            tempAluno.setNotaPrimeiroSemestre(currentCell.getNumericCellValue());
                            break;
                        case 5:
                            tempAluno.setNotaSegundoSemestre(currentCell.getNumericCellValue());
                            break;
                        case 6:
                            tempAluno.setNotaTerceiroSemestre(currentCell.getNumericCellValue());
                            break;
                    }
                    iteracao++;
                }
                tempAluno.calculaIdade();
                tempAluno.calculaMedia();
                alunos.add(tempAluno);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public static void gerarExcel() throws IOException {

        final String NOME_TABELA = "excelGerado";

        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet
                = workbook.createSheet(NOME_TABELA);

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> studentData
                = new TreeMap<String, Object[]>();

        studentData.put(
                "1",
                new Object[] { "Roll No", "NAME", "Year" });

        studentData.put("2", new Object[] { "128", "Aditya",
                "2nd year" });

        studentData.put(
                "3",
                new Object[] { "129", "Narayana", "2nd year" });

        studentData.put("4", new Object[] { "130", "Mohan",
                "2nd year" });

        studentData.put("5", new Object[] { "131", "Radha",
                "2nd year" });

        studentData.put("6", new Object[] { "132", "Gopal",
                "2nd year" });

        Set<String> keyid = studentData.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File("./excelGerado.xlsx"));

        workbook.write(out);
        out.close();
    }

}