package FunctionLayer;

import Exceptions.LegohusException;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import Exceptions.WritingToSQLException;
import java.util.Date;

/**
 * The purpose of LogicFacade is to provide a facade
 * between the Presentation layer and the other layers.
 *
 * @author Gert Lehmann Madsen
 */
public class LogicFacade {

    public static User login(String email, String password) throws LegohusException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LegohusException, WritingToSQLException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(User user, int length, int width, int height) throws LegohusException, WritingToSQLException {
        Order order = new Order(user, length, width, height);
        OrderMapper.createOrder(order);
        user.putToOrderMap(order);
        return order;
    }

    public static void shipOrder(User user, int id) throws LegohusException {
        OrderMapper.setShipped(id);
        Date shippingDate = OrderMapper.getShippingDate(id);
        user.updateOrderStatusInMap(id, shippingDate);
    }
    
    /**
     * Validate if the input made by the customer 
     * meets the requirements for a Lego house.
     * 
     * @param length the length of the house - at least 4 dots
     * @param width the width of the house - at least 4 dots
     * @param height the height of the house - at least 1 brick
     * @return true or false
     */
    public static boolean validateDimensions(int length, int width, int height) {
        boolean result;
        result = (height > 0) & (length > 3) & (width > 3);
        return result;
    }

    public static Bricks calcBricks(User user, int id) {
        Order order = user.getOrderFromMap(id);
        BrickCalculator bc = new BrickCalculator();
        Bricks bricksCalculated = bc.calcFromDimensions(order.getLength(), order.getWidth(), order.getHeight());
        return bricksCalculated;
    }
    
}
