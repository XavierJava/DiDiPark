package com.didipark.utils;

public class Utils {

	public String checkPassword(String passwordStr) {
		String str = "/^[0-9]{1,20}$/"; // ������20λ���������
		String str1 = "/^[0-9|a-z|A-Z]{1,20}$/"; // ����ĸ��������ɣ�������20λ
		String str2 = "/^[a-zA-Z]{1,20}$/"; // ����ĸ������20λ
		if (passwordStr.matches(str)) {
			return "��";
		}
		if (passwordStr.matches(str2)) {
			return "��";
		}
		if (passwordStr.matches(str1)) {
			return "ǿ";
		}
		return passwordStr;

	}
}
