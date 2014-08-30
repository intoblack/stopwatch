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

	private int window = 3; // �зִ��ڴ�С

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
		System.out.println(seg.tokens("�Ұ��й�������"));
		Simhash simHash = new Simhash(seg) ;
		System.out.println(simHash.simhash64("�Ұ��й�������") );
		System.out.println(simHash.simhash64("�Ұ��й�����") );
		System.out.println(simHash.hammingDistance( simHash.simhash64("�������а�ʱ�ݵ������޹�˾λ�ھ��÷�������������������� 1998 �꣬��һ��רҵ���¸�Ƶ��Դģ����з���������������һ��ĸ��¼�����ҵ����ƷΨһ�̱꣺ANSJ  ����׼�̱꣬������ð��'"
				+ "����˾��Ҫ���� 1-600W �ġ� DC/DC ��ģ���Դ�� 1-200W �ġ� AC/DC ��ģ���Դ�� 1-100W�� DC/AC ����������ģ���Դ�� 1-200W �����Դ�����⣬���ṩ 100-500W ����Դ�� 150-300W ���Ӹ��ػ�����Ʒ��ʽ��Ҫ�У�ģ���͡������� �������ͣ��㷺Ӧ�����ʵ硢ͨ�š���Դ������ ϵͳ����ͨ����ز�ҵ�豸�͹�ҵ�Զ������ơ������������Ǳ��豸���졢������ȫϵͳ�����ǽ���ϵͳ�����պ��졢�������������ݲɼ����ڶ�����"
				+ "���Ǽ�֡�׷��׿Խ��Ʒ�ʵ�һ�����������룬������Ϊ������������Ϊ��ּ���ϸ�ִ�� ISO9001-2000 ������������ϵ���������ý���΢����ƬԪ���ͱ��氲װ���գ���������΢�ͻ���ģ�黯��һ�廯����Ϊ���ھ���һ����ģ��ʵ���ĵ�Դģ����Ҫ��Ӧ��֮һ����Ʒ����ȫ������Զ��ŷ�������޵ȷ�����ҡ���˾ӵ��һ֧���ۺ���ƾ��鼫��ḻ���з����飬�������ҵ����Ӫ����Ա���淶��������ϵ���ۺ�ļ���ʵ���������������ںϵ����Դ���¼�������Դǯλ��ͬ����������΢������ѹ����ϱ�����װ������ƽ�弰Ƕ��ʽƽ���ѹ�������幤�գ����ڼ��̵�ʱ����Ϊ���ṩ���ŵ�Դ��Ʒ�����Ϊ���ṩ�ȶ��ɿ��ĵ�Դ�����Ƶ��ۺ����ͼ���֧�֣��ų���ʹ��ģ��ĺ��֮�����µ������Ը��ʱ�ݵ�Դ��Ϊ�������������Ŧ����������Я�ֹ�����ʮһ���ͻԻ͡�"), simHash.simhash64("�������а�ʱ�ݵ������޹�˾λ�ھ��÷�������������������� 1998 �꣬��һ��רҵ���¸�Ƶ��Դģ����з���������������һ��ĸ��¼�����ҵ����ƷΨһ�̱꣺ANSJ  ����׼�̱꣬������ð��'"
						+ "����˾�� DC/DC ��ģ���Դ�� 1-200W �ġ�  ����Դ�� 150-300W ���Ӹ��ػ�����Ʒ��ʽ��Ҫ�У�ģ���͡������� �������ͣ��㷺Ӧ�����ʵ硢ͨ�š���Դ������ ϵͳ����ͨ����ز�ҵ�豸�͹�ҵ�Զ������ơ������������Ǳ��豸���졢������ȫϵͳ�����ǽ���ϵͳ�����պ��졢�������������ݲɼ����ڶ�����"
						+ "���Ǽ�֡�׷һ�����������룬������Ϊ������������Ϊ��ּ���ϸ�ִ�� ISO9001-2000 ������������ϵ���������ý���΢����ƬԪ���ͱ��氲װ���գ���������΢�ͻ���ģ�黯��һ�廯����Ϊ���ھ���һ����ģ��ʵ���ĵ�Դģ����Ҫ��Ӧ��֮һ����Ʒ����ȫ������Զ��ŷ�������޵ȷ�����ҡ���˾ӵ��һ֧���ۺ���ƾ��鼫��ḻ���з����飬�������ҵ����Ӫ����Ա���淶��������ϵ���ۺ�ļ���ʵ���������������ںϵ����Դ���¼�������Դǯλ��ͬ����������΢������ѹ����ϱ�����װ������ƽ�弰Ƕ��ʽƽ���ѹ�������幤�գ����ڼ��̵�ʱ����Ϊ���ṩ���ŵ�Դ��Ʒ�����Ϊ���ṩ�ȶ��ɿ��ĵ�Դ�����Ƶ��ۺ����ͼ���֧�֣��ų���ʹ��ģ��ĺ��֮�����µ������Ը��ʱ�ݵ�Դ��Ϊ�������������Ŧ����������Я�ֹ�����ʮһ���ͻԻ͡�")));
	}

}
