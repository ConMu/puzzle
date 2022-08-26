package createpattern.abstractfactory.impl;


import createpattern.abstractfactory.inter.Shape;

/**
 * @author mucongcong
 * @date 2022/08/05 16:58
 * @since
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
