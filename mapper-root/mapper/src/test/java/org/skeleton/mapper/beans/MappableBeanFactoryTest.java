package org.skeleton.mapper.beans;

import org.junit.Assert;
import org.junit.Test;
import org.skeleton.mapper.Dummy;
import org.skeleton.mapper.beans.AccessibleField;
import org.skeleton.mapper.beans.MappableBean;
import org.skeleton.mapper.beans.MappableBeanFactory;

public class MappableBeanFactoryTest {
	
	@Test
	public void testMappableBeanFactory() {
		MappableBean<Dummy> dummyBean = MappableBeanFactory.getMappableBean(Dummy.class);
		
		System.out.println(dummyBean.beanClass.getName());
		for (AccessibleField accessibleField:dummyBean.accessibleFields.values()) {
			System.out.println(accessibleField.field.getName());
			System.out.println(accessibleField.getter.getName());
			System.out.println(accessibleField.setter.getName());
			
			Assert.assertEquals(dummyBean.accessibleFields.values().size(),5);
		}
	}
}