/**
 * 
 */
package com.sm.biz.result;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sm.biz.result.BasicResultCode;

/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年8月3日 上午5:31:24
 */
public class BasicResultCodeTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void resultCode() {
		BasicResultCode code = BasicResultCode.DAO_FAILURE;
		Assert.assertEquals("DAO_FAILURE", code.getName());
		Assert.assertEquals(50001, code.getCode());
		Assert.assertEquals("执行数据访问操作失败", code.getMessage().getMessage());
		code = BasicResultCode.SUCCESS;
		Assert.assertEquals("SUCCESS", code.getName());
		Assert.assertEquals(20000, code.getCode());
		Assert.assertEquals("执行成功", code.getMessage().getMessage());
	}


}
