/**
 * 
 */
package com.intoblack.stopwatch.simhash;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author zhangcheng
 *
 */
public class BinaryWordSeg implements IWordSeg {

	private int window = 3; // 切分窗口大小

	public int getWindow() {
		return window;
	}

	
	
	public BinaryWordSeg()
	{
		
	}
	
	
	public BinaryWordSeg(int window)
	
	{
		this() ;
		if(window < 2 && window > 10 )
		{
			throw new IllegalArgumentException("window >=2 && window < 10 ") ;
		}
		this.window = window ;
	}
	public void setWindow(int window) {
		this.window = window;
	}

	public List<String> tokens(String doc) {
		List<String> binaryWords = new LinkedList<String>();
		for (int i = 0; i < doc.length() - window + 1; i++) {
			StringBuilder bui = new StringBuilder();
			for (int j = 0; j < window; j++) {
				bui.append(doc.charAt(j + i));
			}
			binaryWords.add(bui.toString());
		}
		return binaryWords;
	}

	public List<String> tokens(String doc, Set<String> stopWords) {
		return null;
	}
	
	
	
	public static void main(String args[])
	{
		BinaryWordSeg seg = new BinaryWordSeg(2) ;
		System.out.println(seg.tokens("我爱中国共产党"));
	}

}
