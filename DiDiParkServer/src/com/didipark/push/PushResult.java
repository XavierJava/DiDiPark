package com.didipark.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.didipark.utils.MyConstant;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.IIGtPush;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class PushResult {

	@SuppressWarnings("unchecked")
	public static void pushResultToCustom(String cid, int customerId,String content) throws Exception {
		// ���÷���ÿ���û������û�״̬����ѡ
		System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
		IGtPush push = new IGtPush(MyConstant.PUSH_APP_HOST,
				MyConstant.PUSH_APP_KEY, MyConstant.PUSH_APP_MASTER_SECRET);
		// �������ӣ���ʼ��Ȩ
		push.connect();
		// ֪ͨ͸��ģ��
		TransmissionTemplate template = transmissionTemplateDemo("1002-"+content+","+customerId);

		ListMessage message = new ListMessage();
		message.setData(template);

		// ������Ϣ���ߣ�����������ʱ��
		message.setOffline(true);
		// ������Чʱ�䣬��λΪ���룬��ѡ
		message.setOfflineExpireTime(24 * 1000 * 3600);

		// ��������Ŀ��
		List targets = new ArrayList();
		Target target = new Target();
		target.setAppId(MyConstant.PUSH_APP_ID);
		// �û��������ͣ�cid���û�����2��ֻ��ѡ��һ
		// String alias1 = "��";
		// target1.setAlias(alias1);
		target.setClientId(cid);
		targets.add(target);
		// ��ȡtaskID
		String taskId = push.getContentId(message);
		// ʹ��taskID��Ŀ���������
		IPushResult ret = push.pushMessageToList(taskId, targets);
		// ��ӡ������������Ϣ
		System.out.println(ret.getResponse().toString());
	}
	public static void pushResultToCarportOwner(String cid, String content,String carportId) throws Exception {
		// ���÷���ÿ���û������û�״̬����ѡ
		System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
		IGtPush push = new IGtPush(MyConstant.PUSH_APP_HOST,
				MyConstant.PUSH_APP_KEY, MyConstant.PUSH_APP_MASTER_SECRET);
		// �������ӣ���ʼ��Ȩ
		push.connect();
		// ֪ͨ͸��ģ��
		TransmissionTemplate template = transmissionTemplateDemo("1003-"+content+","+carportId);

		ListMessage message = new ListMessage();
		message.setData(template);

		// ������Ϣ���ߣ�����������ʱ��
		message.setOffline(true);
		// ������Чʱ�䣬��λΪ���룬��ѡ
		message.setOfflineExpireTime(24 * 1000 * 3600);

		// ��������Ŀ��
		List targets = new ArrayList();
		Target target = new Target();
		target.setAppId(MyConstant.PUSH_APP_ID);
		// �û��������ͣ�cid���û�����2��ֻ��ѡ��һ
		// String alias1 = "��";
		// target1.setAlias(alias1);
		target.setClientId(cid);
		targets.add(target);
		// ��ȡtaskID
		String taskId = push.getContentId(message);
		// ʹ��taskID��Ŀ���������
		IPushResult ret = push.pushMessageToList(taskId, targets);
		// ��ӡ������������Ϣ
		System.out.println(ret.getResponse().toString());
	}
	public static TransmissionTemplate transmissionTemplateDemo(String content) {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(MyConstant.PUSH_APP_ID);
		template.setAppkey(MyConstant.PUSH_APP_KEY);
		// ͸����Ϣ���ã�1Ϊǿ������Ӧ�ã��ͻ��˽��յ���Ϣ��ͻ���������Ӧ�ã�2Ϊ�ȴ�Ӧ������
		template.setTransmissionType(2);
		template.setTransmissionContent(content);
		return template;
	}

}
