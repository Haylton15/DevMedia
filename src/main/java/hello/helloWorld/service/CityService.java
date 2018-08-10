/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.helloWorld.service;

import hello.helloWorld.bean.City;
import hello.helloWorld.repository.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Haylton
 */
@Service
public class CityService implements ICityService{
    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {
       List<City> cities = (List<City>) repository.findAll();
       return cities;
    }
}
