/**
 *
 */
package org.springframework.batch.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * @author Lucas Ward
 *
 */
public class JobParameterTests {

	JobParameter jobParameter;

	@Test
	public void testStringParameter(){
		jobParameter = new JobParameter("test", true);
		assertEquals("test", jobParameter.getValue());
	}

	@Test
	public void testNullStringParameter(){
		jobParameter = new JobParameter((String)null, true);
		assertEquals(null, jobParameter.getValue());
	}

	@Test
	public void testLongParameter(){
		jobParameter = new JobParameter(1L, true);
		assertEquals(1L, jobParameter.getValue());
	}

	@Test
	public void testDoubleParameter(){
		jobParameter = new JobParameter(1.1, true);
		assertEquals(1.1, jobParameter.getValue());
	}

	@Test
	public void testDateParameter(){
		Date epoch = new Date(0L);
		jobParameter = new JobParameter(epoch, true);
		assertEquals(new Date(0L), jobParameter.getValue());
	}

	@Test
	public void testNullDateParameter(){
		jobParameter = new JobParameter((Date)null, true);
		assertEquals(null, jobParameter.getValue());
	}

	@Test
	public void testDateParameterToString(){
		Date epoch = new Date(0L);
		jobParameter = new JobParameter(epoch, true);
		assertEquals("0", jobParameter.toString());
	}

	@Test
	public void testEquals(){
		jobParameter = new JobParameter("test", true);
		JobParameter testParameter = new JobParameter("test", true);
		assertTrue(jobParameter.equals(testParameter));
	}

	@Test
	public void testHashcode(){
		jobParameter = new JobParameter("test", true);
		JobParameter testParameter = new JobParameter("test", true);
		assertEquals(testParameter.hashCode(), jobParameter.hashCode());
	}

	@Test
	public void testEqualsWithNull(){
		jobParameter = new JobParameter((String)null, true);
		JobParameter testParameter = new JobParameter((String)null, true);
		assertTrue(jobParameter.equals(testParameter));
	}

	@Test
	public void testEqualsWithNullAndDifferentType(){
		jobParameter = new JobParameter((String)null, true);
		JobParameter testParameter = new JobParameter((Date)null, true);
		assertFalse(jobParameter.equals(testParameter));
	}

	@Test
	public void testHashcodeWithNull(){
		jobParameter = new JobParameter((String)null, true);
		JobParameter testParameter = new JobParameter((String)null, true);
		assertEquals(testParameter.hashCode(), jobParameter.hashCode());
	}

}