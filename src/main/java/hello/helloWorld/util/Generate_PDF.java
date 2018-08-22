package hello.helloWorld.util;

import com.itextpdf.text.Chunk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import hello.helloWorld.bean.Calendario;
import hello.helloWorld.bean.City;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Generate_PDF {

//    public Document retornaPdf() throws IOException{
//        try {
//			String file_name="C:\\Users\\Haylton\\teste.pdf";
//			
//			Document document = new Document();
//			
//			PdfWriter.getInstance(document, new FileOutputStream(file_name));
//			
//			document.open();
//			
//			Paragraph para = new Paragraph("This is testing from Haylton");
//                        document.add(para);
//                        document.add(new Paragraph(" "));
//                        PdfPTable table = new PdfPTable(3);
//                        PdfPCell c1 = new PdfPCell(new Phrase("Heading 1"));
//                        table.addCell(c1);
//                        
//                        c1 = new PdfPCell(new Phrase("Heading 2"));
//                        table.addCell(c1);
//                        
//                        c1 = new PdfPCell(new Phrase("Heading 3"));
//                        table.addCell(c1);
//                        table.setHeaderRows(1);
//                        
//                        
//                        table.addCell("1.0");
//                        table.addCell("1.1");
//                        table.addCell("1.2");
//                        table.addCell("2.1");
//                        table.addCell("2.2");
//                        table.addCell("2.3");
//                        
//                        
//			
//                        document.add(table);
//                        
//                        Image image = Image.getInstance("C:\\Users\\Haylton\\bb-logo.png");
//
//                        
//                        document.add(image); 
//                        
//                        
//			
//			
//			System.out.println("finished");
//			
//			
//			document.close();
//                        return document;
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			
//			e.printStackTrace();
//		}
//                return null;
//        
//    
//	
//}
    public static ByteArrayInputStream citiesReport(List<City> cities, List<Calendario> datas, Integer id, String chave) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Population", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (City city : cities) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(city.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(city.getName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(city.getPopulation())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            //table 2
            PdfPTable table2 = new PdfPTable(12);
            //table2.setWidthPercentage(10);

            PdfPTable table3 = new PdfPTable(12);
            
            PdfPCell cell;
            PdfPCell hcell2;

            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

//            for (Calendario calendario : datas) {
//
//                PdfPCell cell;
//
//                cell = new PdfPCell(new Phrase(calendario.getId().toString()));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table2.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(calendario.getCadastroData().toString()));
//                cell.setPaddingLeft(5);
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//                table2.addCell(cell);
//
//                cell = new PdfPCell(new Phrase(String.valueOf(calendario.getCronogramaData().toString())));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                cell.setPaddingRight(5);
//                table2.addCell(cell);
//            }
//            
            /*for (Calendario calendario : datas) {
                

//                cell = new PdfPCell(new Phrase(calendario.getCadastroData().getMonth().getDisplayName(TextStyle.FULL, new Locale("pt"))));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table2.addCell(cell);
//                
//                
//                 //calendario.getCadastroData().getMonth().getDisplayName(TextStyle.FULL, new Locale("pt"));
//                 if(calendario.getCronogramaData().getMonth().equals(calendario.getCadastroData().getMonth())){
//                     cell = new PdfPCell(new Phrase(calendario.getCronogramaData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
//                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table2.addCell(cell);
//                 } else{
//                     table2.addCell(new Phrase(""));
//                 }
//                 
                cell = new PdfPCell(new Phrase(calendario.getCadastroData().getMonth().getDisplayName(TextStyle.FULL, new Locale("pt"))));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table2.addCell(cell);

                if ( calendario.getCronogramaData()==null) {
                    table2.addCell(new Phrase("----"));
                }else{
                    
                    cell = new PdfPCell(new Phrase(calendario.getCronogramaData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(cell);
                     
                 }

            }*/
            
            List<String> datasReformuladas = new ArrayList<>();
            
            for(Calendario calendario : datas){
                
                if(calendario.getCronogramaData() == null){
                   datasReformuladas.add("");
                }else{
                    datasReformuladas.add(calendario.getCronogramaData().toString());
                }
                
                
                
            }
            
            
            String meses[] = {"Jan", "Fev", "Marc", "Abr", "Maio", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
            String aa= "aa";
            Stream<String> stream = datasReformuladas.stream().filter(teste -> teste.equals("") || teste.equals(aa.getClass()));
            stream.forEach( teste -> System.out.println(teste + "teste"));
           
            
            for(int i =0; i < meses.length; i++){
                
                 cell = new PdfPCell(new Phrase(meses[i]));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table2.addCell(cell);
                
                System.out.println(datasReformuladas.get(i));
                    
                    cell = new PdfPCell(new Phrase(datasReformuladas.get(i)));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table3.addCell(cell);
                
                
                
                
            }

//            
//            for(Calendario calendario : datas){
//                 PdfPCell cell;
//                 
//                 //calendario.getCadastroData().getMonth().getDisplayName(TextStyle.FULL, new Locale("pt"));
//                 cell = new PdfPCell(new Phrase(calendario.getCadastroData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
//                //cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(10f);
//                table2.addCell(cell);
//                 
//                 
//                
//            }
            //hcell = new PdfPCell(table2);
            //hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //table.addCell(hcell);
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            document.add(Chunk.NEWLINE);
            document.add(table2);
            document.add(table3);
            document.add(new Phrase(id));
            document.add(Chunk.NEWLINE);
            document.add(new Phrase(chave));

            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(Generate_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
