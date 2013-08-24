package org.springside.examples.showcase.webservice.soap.response.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springside.examples.showcase.webservice.soap.WsConstants;

/**
 * Web Service传输User信息的DTO.
 * 
 * 只传输外部接口需要的属性.使用JAXB 2.0的annotation标注JAVA-XML映射,尽量使用默认约定.
 * 
 * @author calvin
 */
@XmlRootElement
@XmlType(name = "Message", namespace = WsConstants.NS)
public class MessageDTO {

	private Long id;
	private String title;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		id = value;
	}
	
	/**
	 * 重新实现toString()函数方便在日志中打印DTO信息.
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
