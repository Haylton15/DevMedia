package hello.helloWorld.util;

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
import hello.helloWorld.bean.City;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static ByteArrayInputStream citiesReport(List<City> cities){
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

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(Generate_PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
    }

