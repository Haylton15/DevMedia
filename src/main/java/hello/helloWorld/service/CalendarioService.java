/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.helloWorld.service;

import hello.helloWorld.bean.Calendario;
import hello.helloWorld.repository.CalendarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Haylton
 */
@Service
public class CalendarioService implements ICalendarioService{
    
    @Autowired
    private CalendarioRepository repository;
    
    @Override
    public List<Calendario> findAll() {
        List<Calendario> datas = (List<Calendario>) repository.findAll();
        return datas;
    }
    
}
