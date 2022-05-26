package com.azold6.rodartenogueirabackend.utils;

import com.azold6.rodartenogueirabackend.models.Aluno;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "dados.xlsx";

    public static List<Aluno> readExcel() {
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
}