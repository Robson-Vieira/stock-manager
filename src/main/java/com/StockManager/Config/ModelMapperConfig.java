package com.StockManager.Config;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {

	public static final ModelMapper mapper = new ModelMapper();
	
	public static <O,D> D parseObjects(O origin, Class<D> destination){
		return mapper.map(origin, destination);
	}
	
	public static <O,D> List<D> parseList(List<O> origin, Class<D> destination){
		List<D> D = new ArrayList<>();
		for(O o: origin) {
			D.add(mapper.map(o, destination));
		}
		return D;
	}
}
