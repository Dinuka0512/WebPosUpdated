package org.example.bo;

import org.example.bo.custom.impl.CustomerBOImpl;

public class BOFactory implements SuperBO {
    public static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (boFactory == null)? boFactory = new BOFactory(): boFactory;
    }

    public enum getBoType{
        CUSTOMER
    }

    public SuperBO getBo(getBoType type){
        switch (type){
            case CUSTOMER -> {
                return new CustomerBOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
