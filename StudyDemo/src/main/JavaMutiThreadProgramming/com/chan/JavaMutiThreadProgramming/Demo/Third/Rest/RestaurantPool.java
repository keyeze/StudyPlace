package com.chan.JavaMutiThreadProgramming.Demo.Third.Rest;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * Created by Osborn on 2017/8/10.
 */
public class RestaurantPool {
    //todo:这里需要做单例或者线程池处理.
    public static PrintMachine printMachine = new RestaurantPool.PrintMachine();


    public static class WaitorPool {
        private static final Queue<Waitor> waitorWaitList = new ConcurrentLinkedQueue<>();
        private static final List<Waitor> waitorBussList = Collections.synchronizedList(new LinkedList<>());

        //这里应该是线程池管理中心
        //todo:这里应该加入空域等待函数
        public static Waitor CallWaitor() {
            Waitor waitor = waitorWaitList.poll();
            waitorBussList.add(waitor);
            return waitor;
        }

        //直接解除waitor的服务;
        //todo:这里应该加入唤醒函数
        public static void beFreeWaitor(Waitor waitor) {
            waitorBussList.remove(waitor);
            //waitor完成所有代办任务后才能进入空闲
            waitor.doTask();
            waitorWaitList.add(waitor);
        }
    }


    public static class CustomerPool {

    }


    public static class CookerPool {
        private static final Queue<Cooker> cookerWaitList = new ConcurrentLinkedQueue<>();//空闲cooker名单
        private static final List<Cooker> cookerBussList = Collections.synchronizedList(new LinkedList<>());//忙碌cooker名单

        public static Cooker CallCooker() {
            Cooker cooker = cookerWaitList.poll();
            cookerBussList.add(cooker);
            return cooker;
        }
    }


    public static class OrderPool {
        private static final List<Order> unPayOrderList = Collections.synchronizedList(new LinkedList<>());//未支付订单
        private static final List<Order> commitOrderList = Collections.synchronizedList(new ArrayList<>());//完成支付的订单

        public static List<Order> getTableOrder(String tableNum) {
            return unPayOrderList.stream().filter((order -> order.getTableNum().equals(tableNum))).collect(Collectors.toList());
        }

        public static void addTableOrder(String tableNum, Order order) {
            unPayOrderList.add(order);
        }

        public static void commitOrder(String tableNum) {
            unPayOrderList.stream().filter(order -> order.getTableNum().equals(tableNum)).forEach(order -> {
                order.setStatus(Order.Status.COMINT);
                unPayOrderList.remove(order);
                commitOrderList.add(order);
            });
        }
    }


    public static class PrintMachine {
        private PrintMachine() {
        }

        public void print(PrintMode printMode) {
            //todo:按类名打印不同文件下的日志
            printMode.print();
        }
    }


    public static class TablePool {
        private static final Queue<String> freeTable = new ConcurrentLinkedQueue();
        private static final List<String> bussTable = Collections.synchronizedList(new LinkedList<>());

        //todo :这里应该有个空域打断过程
        public static String prepareTable() {
            String str = freeTable.poll();
            bussTable.add(str);
            return str;
        }
    }
}
