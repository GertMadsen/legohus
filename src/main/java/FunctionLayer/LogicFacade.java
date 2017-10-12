package FunctionLayer;

import Exceptions.LegohusException;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import Exceptions.WritingToSQLException;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LegohusException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LegohusException, WritingToSQLException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder( User user, int length, int width, int height ) throws LegohusException, WritingToSQLException {
        Order order = new Order( user.getId(), length, width, height );
        OrderMapper.createOrder( order );
        user.putToOrderMap(order);
        return order;
    }
    
    

}
