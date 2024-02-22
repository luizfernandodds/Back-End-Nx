package com.nuxeo.tracking.converter;

import org.modelmapper.ModelMapper;

public class ConverterEntity { 
 
	static ModelMapper modelMapper = null;
	
//    public <R> R convertToDto(Object entity, Class<R> resultClass) {
//        return modelMapper.map(entity, resultClass);
//    }
//    
//    public Object convertToEntity(Object obj, Object mapper) {
//        return new ModelMapper().map(mapper, obj.getClass());
//     }
    
//    public static <T, E> E convertToDto(T entity, Class<E> dto) {
//    	modelMapper = new ModelMapper();
//    	return modelMapper.map(entity, dto);
//    }
    
    public static <T> T convertToDto(T entity, Class<T> dto) {
    	modelMapper = new ModelMapper();
    	return modelMapper.map(entity, dto);
    }
}