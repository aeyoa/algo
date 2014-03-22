package ru.ifmo.enf.kogan.t01_lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by arsenykogan on 02/03/14.
 */
public class ReflectionForest {
    public static void main(final String[] args) {
        try {
            final Class<?> truckCls = Class.forName("reflection.Truck"); // Create Truck class
            final Method truckMethods[] = truckCls.getDeclaredMethods(); // Get methods of Truck class
            final Object truckInstance = truckCls.newInstance(); // Create instance of Truck

            truckMethods[2].invoke(truckInstance); // Open door
            truckMethods[2].invoke(truckInstance); // Open door
            truckMethods[2].invoke(truckInstance); // Open door
            truckMethods[3].invoke(truckInstance); // Turn on the lights

            final Object truckWheels[] = (Object[]) truckMethods[5].invoke(truckInstance); // Get TruckWheels from Truck.getWheels()
            final Method wheelsMethods[] = truckWheels[0].getClass().getDeclaredMethods(); // Get methods from TruckWheel

            // Pumping our wheels
            for (Object truckWheel : truckWheels) {
                // if wheel is not pumped
                if (!(Boolean) wheelsMethods[1].invoke(truckWheel)) {
                    wheelsMethods[2].invoke(truckWheel); // Pump it
                }
            }
            truckMethods[4].invoke(truckInstance, 20); // Go

        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
