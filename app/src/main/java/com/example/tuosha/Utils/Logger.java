/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tuosha.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Dolphin
 */
public class Logger {

    private Calendar logCalendar = null;
    private PrintWriter printWriter = null;
    private final ReentrantLock lock = new ReentrantLock();
    private final String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"};

    public Logger() {
        newLog();
    }

    private void checkDate() {
        Calendar currentCalendar = Calendar.getInstance();
        /* �ر�ע�⣬���ﲻҪ�� Calendar ��� CompareTo ��������Ϊ���������� 0��1��-1 �ֱ��ʾ�޲��
         * ����𡢸��������Ҫ�õ���������֮���ʱ���ֵ������ getTimeInMillis �����õ�������
         * ����ֵ�ٽ��бȽϡ�
         */
        long diff = currentCalendar.getTimeInMillis() - logCalendar.getTimeInMillis();
        if (diff > 24 * 60 * 60 * 1000) newLog(); // ʱ��������һ���򴴽��µ���־�ļ�
    }

    private void newLog() {
        if (printWriter != null) {
            printWriter.flush();
            printWriter.close();
            printWriter = null;
        }

        logCalendar = Calendar.getInstance();
        /* ����־�ļ����ڱ�־��ʱ���붼����Ϊ 0����Ϊ�Ƚϻ�׼����ǰʱ����˻�׼���
         * ������ 24 Сʱ��Ӧ�����µ���־�ļ���
         */
        logCalendar.set(Calendar.HOUR_OF_DAY, 0);
        logCalendar.set(Calendar.MINUTE, 0);
        logCalendar.set(Calendar.SECOND, 0);

        // ������־�ļ�ȫ·����
        String logFileName = String.format("%s%swisco_xxg_mail_mobile_service_%d-%02d-%02d.log", System.getProperty("user.home"), System.getProperty("file.separator"), logCalendar.get(Calendar.YEAR), logCalendar.get(Calendar.MONTH) + 1, logCalendar.get(Calendar.DAY_OF_MONTH));
        try {
	        // �����Զ�ˢ�µĸ�ʽ����ӡ����
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logFileName, true)), true);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    // �ɹ��ⲿ���õ�ͬ������
    public void record(String logInfo) {
        lock.lock();

        try {
            checkDate();
            Calendar currentCalendar = Calendar.getInstance();
	        printWriter.printf("[%d-%02d-%02d %s %02d:%02d:%02d] %s\n", currentCalendar.get(Calendar.YEAR),
		        currentCalendar.get(Calendar.MONTH) + 1, currentCalendar.get(Calendar.DAY_OF_MONTH),
		        WEEKDAYS[currentCalendar.get(Calendar.DAY_OF_WEEK) - 1], currentCalendar.get(Calendar.HOUR_OF_DAY),
		        currentCalendar.get(Calendar.MINUTE), currentCalendar.get(Calendar.SECOND), logInfo);
        } finally {
            lock.unlock();
        }
    }

    // �ɹ��ⲿ���õ�ͬ������
    public void newLine() {
        lock.lock();

        try {
            checkDate();
            printWriter.println();
        } finally {
            lock.unlock();
        }
    }

	public PrintWriter getPrintWriter() {
		return printWriter;
	}

    // �ɹ��ⲿ���õ�ͬ������
    public void close() {
        lock.lock();

        try {
            printWriter.flush();
            printWriter.close();
        } finally {
	        printWriter = null;
            lock.unlock();
        }
    }
}
