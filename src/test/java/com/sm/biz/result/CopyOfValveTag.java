/**
 * 
 */
package com.sm.biz.result;

import com.sm.biz.result.ResultCode;
import com.sm.biz.result.ResultCodeMessage;
import com.sm.biz.result.ResultCodeUtil;

/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年8月4日 下午5:27:39
 */
public enum CopyOfValveTag implements ResultCode {

	CREATE_REPORT, REPORT_FILE_RECORD, CUSTOM_REPORT_VIEW, 
	STANDARD_REPORT_VIEW, STANDARD_GROUP_VIEW, STANDARD_PLAN_VIEW, 
	STANDARD_ACCOUNT_VIEW, CSV_IMPORT, SEND_DOWNLOAD_MAIL, 
	SEND_REMOVED_MAIL, UPDATE_RECORD, PIPELINE_FAIL ;

//	public boolean isErrorHandler() {
//		return false;
//	}

	private final ResultCodeUtil util = new ResultCodeUtil(this);

	@Override
	public String getName() {
		return util.getName();
	}

	@Override
	public ResultCodeMessage getMessage() {
		return util.getMessage();
	}

	@Override
	public int getCode() {
		return util.getCode();
	}
	
	
	public static void main(String[] args) {
		for(CopyOfValveTag vt : CopyOfValveTag.values()) {
			System.out.println(vt.getCode());
		}
	}

}
