package cn.xiake_hf.shape;

import java.awt.*;

/**
 *  
 */
public class Line extends AbstractShape {

    public Line() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(width));
        g.drawLine(x1, y1, x2, y2);
    }

}
