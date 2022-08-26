package createpattern.builder.impl;

import createpattern.builder.inter.Packing;

/**
 * @author mucongcong
 * @date 2022/08/11 20:44
 * @since
 **/
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
