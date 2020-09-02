package com.liuyq.design.mediator;

/**
 * @author: liuyuqing
 * @Date: 2020/8/26 23:05
 */
public class MediatorTest {

    public static void main(String[] args){
        ConcreteMediator concreteMediator = new ConcreteMediator();

        //让同事认识中介者
        ConcreteColleague1 colleague1 = new ConcreteColleague1(concreteMediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(concreteMediator);

        //让中介者认识同事
        concreteMediator.setColleague2(colleague2);
        concreteMediator.setColleague1(colleague1);

        colleague1.send("吃了吗");
        colleague2.send("没呢");

    }
}
