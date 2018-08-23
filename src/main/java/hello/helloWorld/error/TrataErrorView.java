/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.helloWorld.error;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Haylton
 */
@Component //é necessário transformaar essa classe em um bean gerenciável pelo spring
public class TrataErrorView implements ErrorViewResolver{

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
        //status tem os dados referente ao erro do status que ocorreu 
        //model mensagens atuais recorrentes ao erro que ocorreu 
        ModelAndView model = new ModelAndView("/error");
        model.addObject("status", status.value());
        
        switch(status.value()){
            case 404:
                model.addObject("error", "Página não encontrada. 404 hehe");
                model.addObject("message", "A url para a página '" +map.get("path") + "' não existe."); //path é a chave que tá dentro de map. para saber quais são a chave, use o foreach
                break;
            case 500:
                model.addObject("error", "Ocorreu um erro interno no servidor. 500 hehe");
                model.addObject("message", "Ocorreu um erro inexperado, tente novamente mais tade.");
                break;
            default:
                model.addObject("error", map.get("error")); //chave, valor
                model.addObject("message", map.get("message"));
        
        }
        
        return model;
    }
    
}
