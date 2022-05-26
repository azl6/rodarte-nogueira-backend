package com.azold6.rodartenogueirabackend.utils;

import com.azold6.rodartenogueirabackend.dto.AlunoResponseDTO;
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

    public static void gerarExcel(List<AlunoResponseDTO> alunosDto) throws IOException {

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
                new Object[] { "Identificação", "Nome", "Idade", "Média" });

        for(int i=0; i<alunosDto.size(); i++){
            studentData.put(String.valueOf(i),
                    new Object[]{
                            alunosDto.get(i).getIdentificacao(),
                            alunosDto.get(i).getNome(),
                            alunosDto.get(i).getIdade(),
                            alunosDto.get(i).getMedia(),
                    });
        }

        Set<String> keyid = studentData.keySet();

        int rowid = 0;


        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for(int i=0; i<objectArr.length; i++){
                Cell cell = row.createCell(cellid++);

                if(i == 1)
                  cell.setCellValue((String) objectArr[i]);
                else if (i==3)
                  cell.setCellValue((Double) objectArr[i]);
                else
                  cell.setCellValue((Integer) objectArr[i]);
            }
        }

        FileOutputStream out = new FileOutputStream(
                new File("./excelGerado.xlsx"));

        workbook.write(out);
        out.close();
    }
}