package org.sklsft.mapper.impl;

import org.sklsft.mapper.beans.AccessibleField;
import org.sklsft.mapper.beans.MappableBean;
import org.sklsft.mapper.beans.MappableBeanFactory;
import org.sklsft.mapper.interfaces.Mapper;

public class BasicMapperImpl<T, U> implements Mapper<T, U> {
	
private final MappableBean<T> mappableBean1;
	
	private final MappableBean<U> mappableBean2;
	
	public BasicMapperImpl (Class<T> clazz1, Class<U> clazz2) {
		mappableBean1 = MappableBeanFactory.getMappableBean(clazz1);
		mappableBean2 = MappableBeanFactory.getMappableBean(clazz2);
	}

	@Override
	public T mapFrom(T obj1, U obj2) {
		
		for (AccessibleField field1:mappableBean1.accessibleFields.values()) {
			String fieldName = field1.field.getName();
			AccessibleField field2 = mappableBean2.accessibleFields.get(fieldName);
			
			if (field2 != null && field1.isCompatibleWith(field2)) {
				mappableBean1.setValue(fieldName, mappableBean2.getValue(fieldName, obj2), obj1);
			}
		}
		
		return obj1;
	}

	@Override
	public U mapTo(T obj1, U obj2) {
		
		for (AccessibleField field2:mappableBean2.accessibleFields.values()) {
			String fieldName = field2.field.getName();
			AccessibleField field1 = mappableBean1.accessibleFields.get(fieldName);
			
			if (field1 != null && field2.isCompatibleWith(field1)) {
				mappableBean2.setValue(fieldName, mappableBean1.getValue(fieldName, obj1), obj2);
			}
		}
		
		return obj2;
	}
}
