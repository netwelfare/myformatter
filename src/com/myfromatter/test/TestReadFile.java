package com.myfromatter.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class TestReadFile {

	public static void main(String[] args) throws IOException {
		
		List<String> list = new ArrayList<String>();
		String path="D:\\git\\myformatter\\file\\origin\\Test.java";
		File f = new File(path);
		FileReader fr = new FileReader(f);//读取文件
		BufferedReader br=new BufferedReader(fr);//对reader进行缓存，reader其实包含好几类的。
		String line=null;
		while((line = br.readLine())!=null){
			//System.out.println(line);
			list.add(line);
		}
		listRemoveBlankLineHandle(list);
		//System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		dakuohao(list);
		println(list);
		br.close();
	}
	
	
	public static void listRemoveBlankLineHandle(List<String> list){
		if(list.size()==0){
			return;
		}
		Iterator<String> i=list.iterator();
		while(i.hasNext())
		{
			String temp = i.next();
			if(StringUtils.isBlank(temp))
			{
				i.remove();
			}
		}
	}
	
	public static void dakuohao(List<String> list){
		if(list.size()==0)
		{
			return;
		}
		for(int size =list.size(),i=0;i<size;i++)
		{
			String  line = list.get(i);
			if(line.contains("{") && line.length()!=1)
			{
				int index = line.indexOf("{");
				if(index==line.length()-1)
				{
				  String s1 = line.substring(0, index);
				  list.remove(i);
				  list.add(i,s1);
				  list.add(i+1,"{");
				  i++;
				}
			}
		}
	}
	
	
	public static void println(List<String> list)
	{
		if(list.size()==0)
		{
		return;
		}
		Iterator<String> i=list.iterator();
		while(i.hasNext())
		{
				String temp = i.next();
				System.out.println(temp);
		}
	}
}
