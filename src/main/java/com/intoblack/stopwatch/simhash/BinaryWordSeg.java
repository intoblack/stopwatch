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
		Simhash simHash = new Simhash(seg) ;
		System.out.println(simHash.simhash64("我爱中国共产党") );
		System.out.println(simHash.simhash64("我爱中共产党") );
		System.out.println(simHash.hammingDistance( simHash.simhash64("　深圳市安时捷电子有限公司位于经济发达的深圳特区，成立于 1998 年，是一家专业从事高频电源模块的研发、生产、销售于一体的高新技术企业。产品唯一商标：ANSJ  请认准商标，谨防假冒。'"
				+ "本公司主要生产 1-600W 的“ DC/DC ”模块电源； 1-200W 的“ AC/DC ”模块电源； 1-100W的 DC/AC 铃流发生器模块电源； 1-200W 开板电源；另外，还提供 100-500W 逆变电源； 150-300W 电子负载机。产品形式主要有：模块型、开板型 、特殊型，广泛应用于邮电、通信、能源、电力 系统、交通等相关产业设备和工业自动化控制、电子仪器、仪表，设备制造、消防安全系统、卫星接收系统、航空航天、航海船舶、数据采集等众多领域。"
				+ "我们坚持“追求卓越、品质第一”的质量方针，以信誉为本，服务至上为宗旨，严格执行 ISO9001-2000 的质量管理体系，大量采用进口微型贴片元件和表面安装工艺，真正做到微型化、模块化、一体化，成为国内具有一定规模、实力的电源模块主要供应商之一，产品畅销全国，并远销欧美、亚洲等发达国家。公司拥有一支理论和设计经验极其丰富的研发队伍，优秀的企业管理及营销人员，规范的销售体系。雄厚的技术实力及开发能力，融合当今电源最新技术，有源钳位、同步整流、超微晶磁稳压、结合表面贴装、独立平板及嵌入式平板变压和铝基板工艺，可在极短的时间内为您提供最优电源设计方案，为您提供稳定可靠的电源。完善的售后服务和技术支持，排除您使用模块的后顾之忧在新的世纪里，愿安时捷电源成为连接我们友谊的纽带，让我们携手共创二十一世纪辉煌。"), simHash.simhash64("　深圳市安时捷电子有限公司位于经济发达的深圳特区，成立于 1998 年，是一家专业从事高频电源模块的研发、生产、销售于一体的高新技术企业。产品唯一商标：ANSJ  请认准商标，谨防假冒。'"
						+ "本公司“ DC/DC ”模块电源； 1-200W 的“  逆变电源； 150-300W 电子负载机。产品形式主要有：模块型、开板型 、特殊型，广泛应用于邮电、通信、能源、电力 系统、交通等相关产业设备和工业自动化控制、电子仪器、仪表，设备制造、消防安全系统、卫星接收系统、航空航天、航海船舶、数据采集等众多领域。"
						+ "我们坚持“追一”的质量方针，以信誉为本，服务至上为宗旨，严格执行 ISO9001-2000 的质量管理体系，大量采用进口微型贴片元件和表面安装工艺，真正做到微型化、模块化、一体化，成为国内具有一定规模、实力的电源模块主要供应商之一，产品畅销全国，并远销欧美、亚洲等发达国家。公司拥有一支理论和设计经验极其丰富的研发队伍，优秀的企业管理及营销人员，规范的销售体系。雄厚的技术实力及开发能力，融合当今电源最新技术，有源钳位、同步整流、超微晶磁稳压、结合表面贴装、独立平板及嵌入式平板变压和铝基板工艺，可在极短的时间内为您提供最优电源设计方案，为您提供稳定可靠的电源。完善的售后服务和技术支持，排除您使用模块的后顾之忧在新的世纪里，愿安时捷电源成为连接我们友谊的纽带，让我们携手共创二十一世纪辉煌。")));
	}

}
