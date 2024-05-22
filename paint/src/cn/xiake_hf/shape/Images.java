package cn.xiake_hf.shape;

import java.awt.*;

/**
 *  
 */
public class Images extends AbstractShape {


    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 0, board);
    }


}
