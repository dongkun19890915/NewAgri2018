package com.sinosoft.agriclaim.core.common.utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @description xml和bean相互转化工具类
 * @author 杨航
 * @date 2017年11月30日 下午3:25:53
 */
public final class XMLUtils {
	public static Document newDocument() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		return document;
	}

	public static Document parse(File file) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		document.normalize();
		return document;
	}

	public static Document parse(InputStream is) throws Exception {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = builder.parse(is);
		document.normalize();
		return document;
	}

	public static Document parse(String fileName) throws Exception {
		return parse(new File(fileName));
	}

	public static Node getSingleNodeByTag(Document document, String tagName) {
		NodeList nodeList = document.getElementsByTagName(tagName);
		int length = nodeList.getLength();
		if (length == 1) {
			return nodeList.item(0);
		}
		return null;
	}

	public static String getNodeAttribute(Node currentNode, String attrName) {
		String value = "";
		if (currentNode.getAttributes().getNamedItem(attrName) != null) {
			value = currentNode.getAttributes().getNamedItem(attrName).getNodeValue();
		}

		value = nullToEmpty(value);
		return value;
	}

	public static Node getChildNodeByTagName(Node currentNode, String tagName) {
		Node returnNode = null;
		NodeList nodeList = currentNode.getChildNodes();
		Node node = null;
		int i = 0;
		for (int n = nodeList.getLength(); i < n; ++i) {
			node = nodeList.item(i);
			if (node.getNodeName().equals(tagName)) {
				returnNode = node;
				break;
			}
		}
		return returnNode;
	}
    /**
      * @description 根据标签名获取所有的子节点对象
      * @author 杨航
      * @date 2017年12月2日 上午10:47:38
      * @param currentNode 当前的节点
      * @param tagName 标签名
      * @return tempNodes 获取到的节点数组
     */
	public static Node[] getChildNodesByTagName(Node currentNode, String tagName) {
		List<Node> nodes = new ArrayList<>();
		if ((currentNode == null) || (!currentNode.hasChildNodes())) {
			return new Node[0];
		}
		NodeList nodeList = currentNode.getChildNodes();
		Node node = null;
		int i = 0;
		for (int n = nodeList.getLength(); i < n; ++i) {
			node = nodeList.item(i);
			if (node.getNodeName().equals(tagName)) {
				nodes.add(node);
			}
		}
		Node[] tempNodes = new Node[nodes.size()];
		nodes.toArray(tempNodes);
		return tempNodes;
	}

	public static Node[] getChildElements(Node currentNode) {
		List<Node> nodes = new ArrayList<>();
		if ((currentNode == null) || (!currentNode.hasChildNodes())) {
			return new Node[0];
		}
		NodeList nodeList = currentNode.getChildNodes();
		Node node = null;
		int i = 0;
		for (int n = nodeList.getLength(); i < n; ++i) {
			node = nodeList.item(i);
			if (node.getNodeType() == 1) {
				nodes.add(node);
			}
		}
		Node[] tempNodes = new Node[nodes.size()];
		nodes.toArray(tempNodes);
		return tempNodes;
	}
    /**
      * @description 获取子节点的值
      * @author 杨航
      * @date 2017年12月2日 上午10:46:19
      * @param currentNode 当前节点
      * @param nodeName 子节点的名称
      * @return value 子节点的值
     */
	public static String getChildNodeValue(Node currentNode, String nodeName) {
		String value = "";
		NodeList nodeList = currentNode.getChildNodes();
		Node node = null;
		int i = 0;
		for (int n = nodeList.getLength(); i < n; ++i) {
			node = nodeList.item(i);
			if (node.getNodeName().equals(nodeName)) {
				if (node.getFirstChild() == null)
					break;
				value = nullToEmpty(node.getFirstChild().getNodeValue());
				break;
			}

		}

		return value;
	}

	private static String nullToEmpty(String str) {
		return (str == null) ? "" : str;
	}

	public static void writeXMLFile(Document document, String fileName) throws Exception {
		DOMSource source = new DOMSource(document);
		writeXMLFile(source, fileName);
	}

	public static void writeXMLFile(DOMSource source, String fileName) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();

		StreamResult fileResult = new StreamResult(new File(fileName));
		transformer.transform(source, fileResult);
	}

	public static void writeXMLFile(Node node, String fileName) throws Exception {
		DOMSource source = new DOMSource(node);
		writeXMLFile(source, fileName);
	}
    /**
      * @description 根据路径获取子节点
      * @author 杨航
      * @date 2017年12月2日 上午10:49:06
      * @param currentNode 当前的节点
      * @param path 路径
      * @return node 获取到的节点对象
     */
	public static Node getChildNodeByPath(Node currentNode, String path) {
		String tagName = path;
		int pos = path.indexOf("/");
		if (pos > -1) {
			tagName = path.substring(0, pos);
			path = path.substring(pos + 1);
			if (tagName.equals("")) {
				return getChildNodeByPath(currentNode, path);
			}
			if (tagName.equals("/")) {
				return getChildNodeByPath(currentNode.getOwnerDocument(), path);
			}
			Node node = getChildNodeByTagName(currentNode, tagName);
			if (node == null) {
				return null;
			}
			return getChildNodeByPath(node, path);
		}
		return getChildNodeByTagName(currentNode, tagName);
	}

	public static void main(String[] args) throws Exception {
	}
}