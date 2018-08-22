package hello.helloWorld.controller;

import hello.helloWorld.bean.Calendario;
import hello.helloWorld.bean.City;
import hello.helloWorld.service.ICalendarioService;
import hello.helloWorld.service.ICityService;
import hello.helloWorld.util.Generate_PDF;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Haylton
 */
@RestController
public class CalculatorController {
    
    @Autowired
    ICityService cityService;
    //input: http:localhost:8080/square?num=12
    @Autowired
    ICalendarioService calendarioService;
    
    
    @RequestMapping("/square")
    public String calculateSquare(@RequestParam int num){
        String output = "Square of " + num+ " is " + (num*num);
        return output;
    }
    
    @RequestMapping(value = "/getpdf", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadPDF() throws IOException{
        ClassPathResource pdfFile = new ClassPathResource("teste_dynamic.pdf");
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
        
    }
    
    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
           produces = "application/pdf")
    public ResponseEntity<InputStreamResource> citiesReport(@RequestParam String id) throws IOException {

        List<City> cities = (List<City>) cityService.findAll();
        List<Calendario> datas = (List<Calendario>) calendarioService.findAll();
        
        byte[] decoded= Base64.decodeBase64(id.getBytes());
        String decodedString = new String(decoded);
        
        Integer indicador = Integer.parseInt(decodedString.split("/")[0]);
        String chave = decodedString.split("/")[1];
        ByteArrayInputStream bis = Generate_PDF.citiesReport(cities, datas, indicador, chave);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(bis));

//    return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(pdfFile.contentLength())
//                .contentType(MediaType.parseMediaType("application/pdf"))
//                .body(new InputStreamResource(pdfFile.getInputStream()));
    }
    
    
}
