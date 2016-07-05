package com.myfromatter.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class TestReadFile {

  public static void main(String[] args) throws IOException {

    List<String> list = new ArrayList<String>();

    String path = "Test.txt";
    InputStream in = TestReadFile.class.getResourceAsStream(path);
    InputStreamReader in2 = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(in2);// ��reader���л��棬reader��ʵ�����ü���ġ�
    String line = null;
    while ((line = br.readLine()) != null) {
      // System.out.println(line);
      list.add(line);
    }
    removeBlankLine(list);
    // System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    // dakuohao(list);
    insertNewLineCharacter(list);


    println(list);
    br.close();
  }


  public static void removeBlankLine(List<String> list) {
    if (list.size() == 0) {
      return;
    }
    Iterator<String> i = list.iterator();
    while (i.hasNext()) {
      String temp = i.next();
      if (StringUtils.isBlank(temp)) {
        i.remove();
      }
    }
  }

  public static void dakuohao(List<String> list) {
    if (list.size() == 0) {
      return;
    }
    for (int size = list.size(), i = 0; i < size; i++) {
      String line = list.get(i);
      if (line.contains("{") && line.length() != 1) {
        int index = line.indexOf("{");
        if (index == line.length() - 1) {
          String s1 = line.substring(0, index);
          list.remove(i);
          list.add(i, s1);
          list.add(i + 1, "{");
          i++;
        }
      }
    }
  }

  public static void insertNewLineCharacter(List<String> list) {
    int size = list.size();// ��ȡ����
    for (int i = 0; i < size; i++) {
      String line = list.get(i);// ��ȡĳһ��
      if (StringUtils.trimToEmpty(line).length() > 1) {
        char[] ca = line.toCharArray();
        int index = 0;
        while ((index < ca.length) && (ca[index] <= ' ')) {
          index++;
        }
        System.out.println("�ո����" + index);
        int offset = 0;
        while (offset < ca.length) {
          if (ca[offset] == '{' || ca[offset] == '}') {
            if (ca[offset - 1] != '\n' && ca[offset - 1] != '\r' && ca[offset - 1] != '\'') {// ���֮ǰ�Ĳ���n����r������Ҫ����
              int oldLength = ca.length;
              if (index > 0) {
                ca = Arrays.copyOf(ca, oldLength + 1 + index);// ���ݿո�+���з�
                System.arraycopy(ca, offset, ca, offset + 1 + index, oldLength - offset);// offset,
                                                                                         // //
                                                                                         // offset+1+index,
                ca[offset] = '\n';
                for (int m = 1; m < index; m++) {
                  ca[offset + m] = '\0';
                }
                offset = offset + 1 + index;

              } else {
                ca = Arrays.copyOf(ca, oldLength + 1);// ���ݻ��з�
                System.arraycopy(ca, offset, ca, offset + 1, oldLength - offset);
                ca[offset] = '\n';
                offset++;// ��Ϊ�Ѿ������ˣ������±�ҲҪ����
              }
              /*
               * int oldLength2 = ca.length; ca = Arrays.copyOf(ca, oldLength2 + index);
               * System.arraycopy(ca, offset, ca, offset + index, oldLength2 - offset);
               * Arrays.fill(ca, offset, offset + index, ' ');
               */
              list.remove(i);// ɾ��
              list.add(i, new String(ca));
            }
          }
          offset++;
        }
      }
    }
  }


  public static void formatterNewLineCharacter(List<String> list) {

    int size = list.size();// ��ȡ����
    for (int i = 0; i < size; i++) {


    }

  }


  public static void println(List<String> list) {
    if (list.size() == 0) {
      return;
    }
    Iterator<String> i = list.iterator();
    while (i.hasNext()) {
      String temp = i.next();
      System.out.println(temp);
    }
  }
}
