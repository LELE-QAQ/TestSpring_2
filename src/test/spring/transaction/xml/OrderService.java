package test.spring.transaction.xml;

public class OrderService {
    private  OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    public void account()
    {
        orderDao.lessMoney();
        //int i=1/0;
        orderDao.addMoney();
    }
}
