package com.intoblack.stopwatch.md;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultMDHead {
	public static final String LINE_END  = "  ";
	
	
	public static class MDHeadTime implements IMDHead
	{
		private final static SimpleDateFormat dateFormat = new SimpleDateFormat("%YY-%mm-%dd %HH:%MM") ;

		public String makeHead() {
			return String.format("Date: %s%s", dateFormat.format(new Date()) , LINE_END)  ;
		}
		
	}
	
	
	

}
