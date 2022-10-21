package com.ws.service;

import com.ws.model.dto.FruitDto;

import java.util.List;

public interface IFruitService {

    List<FruitDto> findAll();
    FruitDto save(FruitDto fruit);
    FruitDto update(FruitDto fruit , Integer id);
    Boolean delete(Integer id);

}
