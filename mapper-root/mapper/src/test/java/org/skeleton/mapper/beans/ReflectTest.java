package org.skeleton.mapper.beans;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.skeleton.mapper.Dummy;

public class ReflectTest {
	
	@Test
	public void testReflect() {
		
		List<Dummy> list = new ArrayList<Dummy>();
		
		for (TypeVariable<?> variable:list.getClass().getTypeParameters()) {
			System.out.println(variable.getName());
		}
	}
}
