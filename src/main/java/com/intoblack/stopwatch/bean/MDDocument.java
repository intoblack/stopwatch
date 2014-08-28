package com.intoblack.stopwatch.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MDDocument {
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final static String TAG_SPLITER = " ,";
	private String headDate = dateFormat.format(new Date());
	private String author = "";
	private String title = "";
	private List<String> tags = new ArrayList<String>();
	private String category = "";
	private String body = "";

	public String getBody() {
		return body;
	}

	public MDDocument setBody(String body) {
		this.body = body;
		return this;
	}

	public String getHeadDate() {
		return headDate;
	}

	public MDDocument setHeadDate(String headDate) {
		this.headDate = headDate;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public MDDocument setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MDDocument setTitle(String title) {
		this.title = title;
		return this;
	}

	public List<String> getTags() {
		return new ArrayList<String>(tags);
	}

	public MDDocument setTags(List<String> tags) {
		this.tags = tags;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public MDDocument setCategory(String category) {
		this.category = category;
		return this;
	}

	private static String mdFormat(String key, String value) {
		return String.format("%s: %s   \n", key, value);
	}

	private static String listToString(Collection<String> collections,
			String spliter) {
		if (collections == null || collections.isEmpty()) {
			return "";
		}
		StringBuilder buffer = new StringBuilder();
		for (Iterator<String> iter = collections.iterator(); iter.hasNext();) {
			buffer.append(iter.next());
			if (iter.hasNext()) {
				buffer.append(spliter);
			}
		}
		return buffer.toString();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(mdFormat("Date", this.headDate));
		buffer.append(mdFormat("Title", this.title));
		buffer.append(mdFormat("Author", this.author));
		buffer.append(mdFormat("Category", this.category));
		buffer.append(mdFormat("Tags", listToString(tags, TAG_SPLITER)));
		buffer.append("  ");
		buffer.append(this.body);
		return buffer.toString();

	}

	public static void main(String args[]) {
		MDDocument md = new MDDocument();
		List<String> tags = new ArrayList<String>();
		Collections.addAll(tags, "1", "2");

		System.out.println(md.setAuthor("li").setTags(tags).setTitle("测试")
				.setBody("正文").toString());
	}

}
