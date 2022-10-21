package com.ws.service.impl;

import com.ws.model.dto.FruitDto;
import com.ws.service.IFruitService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//@ApplicationScoped
//@RequestScoped // FruitService service = new FruitService()

@Singleton
public class FruitService implements IFruitService {

    /*

    private FruitService service;

    if(service == null)
        service = new FruitService();

    return service;

    */


    private Predicate<Integer> validate = x -> x > 0;


    private List<FruitDto> fruits = new ArrayList<>();

    @PostConstruct
    void upSet(){
        fruits.add(FruitDto.builder().id(1).name("Peras").build());
    }

    @Override
    public List<FruitDto> findAll() {
        return fruits;
    }

    @Override
    public FruitDto save(FruitDto fruit) {
        fruits.add(fruit);
        return fruit;
    }

    @Override
    public FruitDto update(FruitDto fruit, Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {

        if(validate.test(fruits.size())) {
            fruits.remove(id - 1);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
